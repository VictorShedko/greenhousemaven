package by.victor.greenhouse.builder;

import by.victor.greenhouse.entity.*;
import by.victor.greenhouse.entity.GreenHouseField;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

public class StAXGreenHouseBuilder extends AbstractGreenhouseBuilder {
    private static final Logger logger = Logger.getLogger(StAXGreenHouseBuilder.class);

    private XMLInputFactory inputFactory;
    private Plant currentPlant = null;
    private VisualParameters currentVisualParameters = null;
    private GrowingTips currentGrowingTips = null;
    private Flower.FloweringTime currentFloweringTime = null;
    private Flower.PossibleInflorescenceColor currentInflorescenceColor = null;

    private Deque<GreenHouseField> processingElemets = new ArrayDeque<>();

    public StAXGreenHouseBuilder() {
        inputFactory = XMLInputFactory.newFactory();
    }



    public void startDocument()  {
        plants = new HashSet<>();
    }

    public void parseFlowerAttribute(XMLStreamReader reader) {

        String name=reader.getAttributeValue(null, GreenHouseField.TITLE.name().toLowerCase());
        if (name!=null) {
            currentPlant.setTitle(name);
        }

         String origin=reader.getAttributeValue(null, GreenHouseField.ORIGIN.name());
        if (origin!=null) {
            currentPlant.setOrigin(origin);
        }else {
            currentPlant.setOrigin("unknown");
        }

        String capriciousness=reader.getAttributeValue(null, GreenHouseField.CAPRICIOUSNESS.name());

        if (capriciousness!=null) {
            currentPlant.setCapriciousness(Capriciousness.fromValue(capriciousness));
        }else {
            currentPlant.setCapriciousness(Capriciousness.MEDIUM);
        }
    }


    public void startElement(XMLStreamReader reader) {
        GreenHouseField processingField = GreenHouseField.fromValue(reader.getLocalName());
        processingElemets.addLast(processingField);
        switch (processingField) {
            case PLANT: {
                currentPlant = new Plant();
                parseFlowerAttribute(reader);
            }
            break;
            case FLOWER: {
                currentPlant = new Flower();
                parseFlowerAttribute(reader);
            }
            break;
            case VISUAL_PARAMETERS: {
                currentVisualParameters = new VisualParameters();
            }
            break;
            case GROWING_TIPS: {
                currentGrowingTips = new GrowingTips();
            }
            break;
            case POSSIBLE_INFLORESCENCE_COLOR: {
                currentInflorescenceColor = new Flower.PossibleInflorescenceColor();
                ((Flower) currentPlant).setPossibleInflorescenceColor(currentInflorescenceColor);
            }
            break;

        }

    }

    public void endElement(XMLStreamReader reader) {
        GreenHouseField processingField = GreenHouseField.fromValue(reader.getLocalName());
        processingElemets.pop();
        switch (processingField) {
            case PLANT: {
                plants.add(currentPlant);
            }
            break;
            case FLOWER: {
                plants.add(currentPlant);
            }
            break;
            case VISUAL_PARAMETERS: {
                currentPlant.getVisualParameters().add(currentVisualParameters);
            }
            break;
            case GROWING_TIPS: {
                currentPlant.getGrowingTips().add(currentGrowingTips);
            }
            break;
            case POSSIBLE_INFLORESCENCE_COLOR: {
                ((Flower) currentPlant).setPossibleInflorescenceColor(currentInflorescenceColor);
            }
            break;

        }
    }

    public void characters(XMLStreamReader reader) {
        String s = reader.getText().trim();
        if (!"".equals(s)) {
            GreenHouseField processingField = processingElemets.getLast();
            switch (processingField) {
                case HEIGHT: {
                    currentVisualParameters.setHeight(BigInteger.valueOf(Integer.parseInt(s)));
                }
                break;
                case MIN_TEMPERATURE: {
                    currentGrowingTips.setMinTemperature(Integer.parseInt(s));
                }
                break;
                case MAX_TEMPERATURE: {
                    currentGrowingTips.setMaxTemperature(Integer.parseInt(s));
                }
                break;
                case LEAF_COLOR: {
                    currentVisualParameters.setLeafColor(Color.fromValue(s));
                }
                break;
                case SOIL: {
                    currentPlant.getSoil().add(SoilType.fromValue(s));
                }
                break;
                case STICK_COLOR: {
                    currentVisualParameters.setStickColor(Color.fromValue(s));
                }
                break;
                case HELIOPHILOUS: {
                    currentGrowingTips.setHeliophilous(Boolean.parseBoolean(s));
                }
                break;
                case WATERING: {
                    currentGrowingTips.setWatering(Integer.parseInt(s));
                }
                break;
                case COLOR: {
                    ((Flower) currentPlant).getPossibleInflorescenceColor().getColor().add(Color.fromValue(s));
                }
                break;
                case MULTIPLYING: {
                    currentPlant.getMultiplying().add(MultiplyingType.fromValue(s));
                }
                break;
            }
        }
    }

    public Set<Plant> getPlants() {
        return plants;
    }


    @Override
    public void buildSetFlowers(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            // StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        startElement(reader);
                        break;
                    case XMLStreamConstants.ATTRIBUTE:
                        parseFlowerAttribute(reader);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        characters(reader);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        endElement(reader);
                        break;

                }
            }
        } catch (XMLStreamException ex) {
           logger.error("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            logger.error("File " + fileName + " not found! " + ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                logger.error("Impossible close file " + fileName + " : " + e);
            }
        }
    }

}
