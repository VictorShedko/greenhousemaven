package by.victor.greenhouse.builder;

import by.victor.greenhouse.action.DataParseAction;
import by.victor.greenhouse.entity.*;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class DomGreenhouseBuilder extends AbstractGreenhouseBuilder {
    private static final  Logger logger = Logger.getLogger(DomGreenhouseBuilder.class);
    private DocumentBuilder docBuilder;

    public DomGreenhouseBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error(e);
        }

    }


    private List<String> getElementText(Element element, String elementName) {
        List<String> text = new ArrayList<>();
        NodeList nList = element.getElementsByTagName(elementName);
        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            String string = node.getTextContent();
            text.add(string);
        }
        return text;
    }

    private GrowingTips buildSingleTip(Element growingTipsElement) {
        GrowingTips growingTips = new GrowingTips();
        getElementText(growingTipsElement, GreenHouseField.HELIOPHILOUS.value()).forEach(t -> growingTips.setHeliophilous(Boolean.parseBoolean(t)));
        getElementText(growingTipsElement, GreenHouseField.WATERING.value()).forEach(t -> growingTips.setWatering(Integer.parseInt(t)));
        getElementText(growingTipsElement, GreenHouseField.MIN_TEMPERATURE.value()).forEach(t -> growingTips.setMinTemperature(Integer.parseInt(t)));
        getElementText(growingTipsElement, GreenHouseField.MAX_TEMPERATURE.value()).forEach(t -> growingTips.setMaxTemperature(Integer.parseInt(t)));
        return growingTips;
    }


    private Flower.PossibleInflorescenceColor buildInflorescenceColor(Element inflorescenceColorElement) {
        Flower.PossibleInflorescenceColor inflorescenceColor = new Flower.PossibleInflorescenceColor();
        NodeList colorList = inflorescenceColorElement.getElementsByTagName(GreenHouseField.COLOR.value());
        for (int i = 0; i < colorList.getLength(); i++) {

            String colorString = colorList.item(i).getTextContent();
            inflorescenceColor.getColor().add(Color.fromValue(colorString));

        }
        return inflorescenceColor;
    }


    private List<GrowingTips> buildGrowingTips(Element plantElement) {
        List<GrowingTips> growingTips = new ArrayList<>();
        NodeList tipsList = plantElement.getElementsByTagName(GreenHouseField.GROWING_TIPS.value());
        for (int i = 0; i < tipsList.getLength(); i++) {
            Element tipElement = (Element) tipsList.item(i);
            GrowingTips tip = buildSingleTip(tipElement);
            growingTips.add(tip);
        }
        return growingTips;
    }

    private VisualParameters buildsingleparametr(Element visualParameterElement) {
        VisualParameters visualParameters = new VisualParameters();
        getElementText(visualParameterElement, GreenHouseField.HEIGHT.value()).forEach(t -> visualParameters.setHeight(BigInteger.valueOf(Integer.parseInt(t))));
        getElementText(visualParameterElement, GreenHouseField.STICK_COLOR.value()).forEach(t -> visualParameters.setStickColor(Color.fromValue(t)));
        getElementText(visualParameterElement, GreenHouseField.LEAF_COLOR.value()).forEach(t -> visualParameters.setLeafColor(Color.fromValue(t)));
        return visualParameters;
    }


    private List<VisualParameters> buildVisualParameters(Element plantElement) {
        List<VisualParameters> parameters = new ArrayList<>();
        NodeList parametersList = plantElement.getElementsByTagName(GreenHouseField.VISUAL_PARAMETERS.value());
        for (int i = 0; i < parametersList.getLength(); i++) {
            Element visualParameterElement = (Element) parametersList.item(i);
            VisualParameters parameter = buildsingleparametr(visualParameterElement);
            parameters.add(parameter);
        }
        return parameters;
    }

    private Flower.FloweringTime buildFloweringTime(Element plantElement) {
        Flower.FloweringTime floweringTime = new Flower.FloweringTime();
        DataParseAction dataParseAction = new DataParseAction();
        getElementText(plantElement, GreenHouseField.START_MONTH.value()).forEach(t -> floweringTime.setStartMonth(dataParseAction.parseMonth(t)));
        getElementText(plantElement, GreenHouseField.END_MONTH.value()).forEach(t -> floweringTime.setEndMonth(dataParseAction.parseMonth(t)));
        return floweringTime;
    }


    private void buildFlower(Element flowerElement, Flower flower) {
        buildPlant(flowerElement, flower);
        flower.setPossibleInflorescenceColor(buildInflorescenceColor(flowerElement));
        flower.setFloweringTime(buildFloweringTime(flowerElement));
    }

    private void buildPlant(Element plantElement, Plant plant) {
        plant.setTitle(plantElement.getAttribute(GreenHouseField.TITLE.value()));
        String originString = plantElement.getAttribute(GreenHouseField.ORIGIN.value());
        if (!"".equals(originString)) {
            plant.setOrigin(originString);
        } else {
            plant.setOrigin("unknown");
        }
        String capriciousnessString = plantElement.getAttribute(GreenHouseField.CAPRICIOUSNESS.value());
        if (!"".equals(capriciousnessString)) {
            plant.setOrigin(capriciousnessString);
        } else {
            plant.setOrigin(Capriciousness.MEDIUM.value());
        }
        getElementText(plantElement, GreenHouseField.MULTIPLYING.value()).forEach(t -> plant.getMultiplying().add(MultiplyingType.fromValue(t)));
        getElementText(plantElement, GreenHouseField.SOIL.value()).forEach(t -> plant.getSoil().add(SoilType.fromValue(t)));
        List<GrowingTips> tips = buildGrowingTips(plantElement);
        List<VisualParameters> parameters = buildVisualParameters(plantElement);
        plant.getVisualParameters().addAll(parameters);
        plant.getGrowingTips().addAll(tips);

    }

    @Override
    public void buildSetFlowers(String fileName) {
        Document xmlDoc;
        try {
            xmlDoc = docBuilder.parse(fileName);
            Element root = xmlDoc.getDocumentElement();
            NodeList plantList = root.getElementsByTagName(GreenHouseField.PLANT.value());
            for (int i = 0; i < plantList.getLength(); i++) {
                Element plantElement = (Element) plantList.item(i);
                Plant plant = new Plant();
                buildPlant(plantElement, plant);
                plants.add(plant);
            }
            plantList = root.getElementsByTagName(GreenHouseField.FLOWER.value());
            for (int i = 0; i < plantList.getLength(); i++) {
                Element plantElement = (Element) plantList.item(i);
                Flower flower = new Flower();
                buildFlower(plantElement, flower);
                plants.add(flower);
            }
        } catch (SAXException e) {
            logger.error("problem in SAX",e);
        } catch (IOException e) {
            logger.error("io exception, sax",e);
        }
    }
}
