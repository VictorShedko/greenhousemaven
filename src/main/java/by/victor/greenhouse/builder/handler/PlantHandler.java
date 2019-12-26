package by.victor.greenhouse.builder.handler;

import by.victor.greenhouse.action.DataParseAction;
import by.victor.greenhouse.entity.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import java.math.BigInteger;
import java.util.*;


public class PlantHandler extends DefaultHandler {
    private static final Logger logger=Logger.getLogger(PlantHandler.class);

    private Set<Plant> plants;
    private Plant currentPlant = null;
    private VisualParameters currentVisualParameters = null;
    private GrowingTips currentGrowingTips = null;
    private Flower.FloweringTime currentFloweringTime = null;
    private Flower.PossibleInflorescenceColor currentInflorescenceColor = null;

    private Deque<GreenHouseField> processingElements = new ArrayDeque<>();




    @Override
    public void startDocument() throws SAXException {
        plants = new HashSet<>();
    }

    public void parseFlowerAttribute(Attributes attrs){
        for (int i = 0; i < attrs.getLength(); i++) {
            switch (attrs.getQName(i)) {
                case "origin": {
                    currentPlant.setOrigin(attrs.getValue(i));
                }break;
                case "title": {
                    currentPlant.setTitle(attrs.getValue(i));
                }break;
                case "capriciousness":{
                    currentPlant.setCapriciousness(Capriciousness.fromValue(attrs.getValue(i)));
                }
            }
        }
        if(currentPlant.getCapriciousness()==null){
            currentPlant.setCapriciousness(Capriciousness.MEDIUM);
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        GreenHouseField processingField = GreenHouseField.fromValue(qName);
        processingElements.addLast(processingField);
        switch (processingField) {
            case PLANT: {

                currentPlant = new Plant();
                parseFlowerAttribute(attrs);
            }
            break;
            case FLOWER: {
                currentPlant = new Flower();
                parseFlowerAttribute(attrs);
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
            case FLOWERING_TIME: {
                currentFloweringTime = new Flower.FloweringTime();
            }
            break;
            case POSSIBLE_INFLORESCENCE_COLOR: {
                currentInflorescenceColor = new Flower.PossibleInflorescenceColor();
                ((Flower) currentPlant).setPossibleInflorescenceColor(currentInflorescenceColor);
            }
            break;

        }

    }

    public void endElement(String uri, String localName, String qName) {
        GreenHouseField processingField = GreenHouseField.fromValue(qName);
        processingElements.pop();
        switch (processingField) {
            case PLANT: {
                plants.add(currentPlant);
                logger.log(Level.DEBUG,"find plant :"+currentPlant.getTitle());
            }
            break;
            case FLOWER: {
                plants.add(currentPlant);
            }break;
            case VISUAL_PARAMETERS: {
                currentPlant.getVisualParameters().add(currentVisualParameters);
            }
            break;
            case GROWING_TIPS: {
                currentPlant.getGrowingTips().add(currentGrowingTips);
            }
            break;
            case FLOWERING_TIME: {
                ((Flower) currentPlant).setFloweringTime(currentFloweringTime);
            }
            break;
            case POSSIBLE_INFLORESCENCE_COLOR: {
                ((Flower) currentPlant).setPossibleInflorescenceColor(currentInflorescenceColor);
            }
            break;

        }
    }

    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (!"".equals(s)) {
            GreenHouseField processingField = processingElements.getLast();
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
                case START_MONTH: {
                    DataParseAction dataParseAction=new DataParseAction();
                    currentFloweringTime.setStartMonth(dataParseAction.parseMonth(s));

                }
                break;
                case END_MONTH: {
                    DataParseAction dataParseAction=new DataParseAction();
                    currentFloweringTime.setEndMonth(dataParseAction.parseMonth(s));
                }
            }
        }
    }

    public Set<Plant> getPlants() {
        return plants;
    }

    public void setPlants(Set<Plant> plants) {
        this.plants = plants;
    }
}
