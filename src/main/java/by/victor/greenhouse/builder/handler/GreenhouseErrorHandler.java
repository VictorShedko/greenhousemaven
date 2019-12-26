package by.victor.greenhouse.builder.handler;

import org.apache.log4j.Logger;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

public class GreenhouseErrorHandler implements ErrorHandler {
    private Logger logger = Logger.getLogger(GreenhouseErrorHandler.class);

    public void warning(SAXParseException e) {
        logger.warn(getLineAddress(e) + "-" + e.getMessage());
        throw new GreenhouseContentException();
    }
    public void error(SAXParseException e) {
        logger.error(getLineAddress(e) + " - " + e.getMessage());

        throw new GreenhouseContentException();
    }
    public void fatalError(SAXParseException e) {
        logger.fatal(getLineAddress(e) + " - " + e.getMessage());
        throw new GreenhouseContentException();
    }
    private String getLineAddress(SAXParseException e)
    {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }

}
