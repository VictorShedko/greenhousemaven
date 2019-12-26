package by.victor.greenhouse.builder;

import by.victor.greenhouse.entity.Plant;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.util.Set;

public class StAXTest {
    @Test
    public void xmlStAXTest() throws ParserConfigurationException, SAXException {
        int expected =13;
        Set<Plant> actual= null;
        StAXGreenHouseBuilder stAXGreenHouseBuilder= new StAXGreenHouseBuilder();
        stAXGreenHouseBuilder.buildSetFlowers("test/testresources/greenhouse.xml");
        actual=stAXGreenHouseBuilder.getPlants();
        Assert.assertEquals(actual.size(),expected);
    }
}
