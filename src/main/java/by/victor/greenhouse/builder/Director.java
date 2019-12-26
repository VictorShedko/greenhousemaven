package by.victor.greenhouse.builder;

import by.victor.greenhouse.entity.Plant;
import by.victor.greenhouse.filemanager.GreenhouseFileManager;
import by.victor.greenhouse.builder.validator.GreenhouseValidator;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.Optional;
import java.util.Set;

public class Director {
    private static final Logger logger = Logger.getLogger(Director.class);
    private DomGreenhouseBuilder domGreenhouseBuilder;
    private SaxGreenhouseBuilder saxGreenhouseBuilder;
    private StAXGreenHouseBuilder stAXGreenHouseBuilder;
    private Set<Plant> plants;

    private static final String GREENHOUSE_SCHEME_XSD ="C:/temp/greenhouseScheme.XSD";

    public Director() {
        domGreenhouseBuilder=new DomGreenhouseBuilder();
        try {
            saxGreenhouseBuilder= new SaxGreenhouseBuilder();
        } catch (ParserConfigurationException e) {
            logger.error("problem in SAX, parseConfiguration",e);
        } catch (SAXException e) {
            logger.error("problem in SAX",e);
        }
        stAXGreenHouseBuilder=new StAXGreenHouseBuilder();
    }

    public Optional<Set<Plant>> getPlants() {
        return Optional.ofNullable(plants);
    }

    public void parsePlants(ParseType type){
        GreenhouseValidator validator= new GreenhouseValidator();
        Optional<File> filePath= GreenhouseFileManager.getFileToParse();

        if(filePath.isPresent()&&validator.saxValidation(GREENHOUSE_SCHEME_XSD,filePath.get().getAbsolutePath())) {

            switch (type) {
                case DOM: {
                    domGreenhouseBuilder.buildSetFlowers(filePath.get().getAbsolutePath());
                    plants = domGreenhouseBuilder.getPlants();
                }
                break;
                case SAX: {
                    saxGreenhouseBuilder.buildSetFlowers(filePath.get().getAbsolutePath());
                    plants = saxGreenhouseBuilder.getPlants();
                }
                break;
                case STAX: {
                    stAXGreenHouseBuilder.buildSetFlowers(filePath.get().getAbsolutePath());
                    plants = stAXGreenHouseBuilder.getPlants();
                }
                break;
            }

        }
    }
}
