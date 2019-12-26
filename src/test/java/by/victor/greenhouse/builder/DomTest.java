package by.victor.greenhouse.builder;

import by.victor.greenhouse.entity.Plant;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.util.Set;

public class DomTest {
    @Test
    public void xmlDomTest() throws ParserConfigurationException, SAXException {
        int expected =13;
        Set<Plant> actual= null;
        DomGreenhouseBuilder domGreenhouseBuilder= new DomGreenhouseBuilder();
        domGreenhouseBuilder.buildSetFlowers("test/testresources/greenhouse.xml");
        actual=domGreenhouseBuilder.getPlants();
        Assert.assertEquals(actual.size(),expected);
    }
}
