package by.victor.greenhouse.builder.validator;

import by.victor.greenhouse.builder.handler.GreenhouseContentException;
import by.victor.greenhouse.builder.handler.GreenhouseErrorHandler;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class GreenhouseValidator {
    private static final Logger logger=Logger.getLogger(GreenhouseValidator.class);
    public boolean saxValidation(String schemeFilePath,String xmlFileForValidation){
        boolean result=true;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName =xmlFileForValidation;
        String schemaName = schemeFilePath;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            GreenhouseErrorHandler sh = new GreenhouseErrorHandler();
            validator.setErrorHandler(sh);
            Source source = new StreamSource(fileName);
            validator.validate(source);
            logger.info(fileName + " is valid.");
        } catch (SAXException e) {
            result=false;
            logger.error("validation "+ fileName + " is not valid because ", e);
        } catch (GreenhouseContentException e) {
            result=false;
            logger.error("validation "+ fileName + " is not valid because ",e);

        }
        catch (IOException e) {
            result=false;
            logger.error(fileName + " is not valid because "
                    + e.getMessage());
        }
        return result;
    }


}
