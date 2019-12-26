package by.victor.greenhouse.builder;

import by.victor.greenhouse.builder.handler.PlantHandler;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxGreenhouseBuilder extends AbstractGreenhouseBuilder {
    private static final Logger logger = Logger.getLogger(SaxGreenhouseBuilder.class);
    private SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
    private SAXParser saxParser= saxParserFactory.newSAXParser();

    public SaxGreenhouseBuilder() throws ParserConfigurationException, SAXException {

    }

    public void buildSetFlowers(String fileName) {
        File XMLFile = new File(fileName);
        PlantHandler handler= new PlantHandler();
        try {
            saxParser.parse(XMLFile,handler);
            plants=handler.getPlants();
        } catch (SAXException e) {
            logger.error("problem in sax, SAXException",e);
        } catch (IOException e) {
            logger.error("problem in sax, IO",e);
        }
    }
}
