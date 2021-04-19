package by.silebin.xml_parsing.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FlowerXmlValidatorTest {

    private static final String VALID_XML_PATH = "xml/example.xml";
    private static final String INVALID_XML_PATH = "xml/invalid-example.xml";

    @Test
    public void testIsValidXml_validXml(){
        Assert.assertTrue(FlowerXmlValidator.isValidXml(VALID_XML_PATH));
    }

    @Test
    public void testIsValidXml_invalidXml(){
        Assert.assertFalse(FlowerXmlValidator.isValidXml(INVALID_XML_PATH));
    }
}
