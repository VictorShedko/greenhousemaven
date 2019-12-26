package by.victor.greenhouse.builder.validator;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidatorTest {
    private GreenhouseValidator greenhouseValidator;

    @BeforeClass
    public void setup(){
        greenhouseValidator= new GreenhouseValidator();
    }

    @DataProvider(name = "validator-parameters")
    public Object[][] parameterIntTestProvider() {
        String schemePath = "test/testresources/greenhouseScheme.XSD";
        String xmlFile1 = "test/testresources/greenhouse.xml";
        boolean expected1 = true;

        String xmlFile2 = "test/testresources/greenhouseWithFormedError.xml";
        boolean expected2 = false;


        String xmlFile3 = "test/testresources/greenhouseLogicError.xml";
        boolean expected3 = false;

        String xmlFile4 = "test/testresources/greenhouseIdError.xml";
        boolean expected4 = false;
        return new Object[][]{
                {schemePath, xmlFile1, expected1},
                {schemePath, xmlFile2, expected2},
                {schemePath, xmlFile3, expected3},
                {schemePath, xmlFile4, expected4}
        };
    }

    @Test(dataProvider = "validator-parameters")
    public void saxValidation(String schemePath, String xmlFile, boolean expected) {
        Assert.assertEquals(greenhouseValidator.saxValidation(schemePath,xmlFile), expected);
    }


}
