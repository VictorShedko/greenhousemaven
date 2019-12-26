package by.victor.greenhouse.builder;


import by.victor.greenhouse.entity.Plant;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.util.Set;

public class SaxTest {


    @Test
    public void xmlSaxTest() throws ParserConfigurationException, SAXException {
        int expected =13;
        Set<Plant> actual= null;
        SaxGreenhouseBuilder saxGreenhouseBuilder= new SaxGreenhouseBuilder();
        saxGreenhouseBuilder.buildSetFlowers("test/testresources/greenhouse.xml");
        actual=saxGreenhouseBuilder.getPlants();
        Assert.assertEquals(actual.size(),expected);
    }

}
