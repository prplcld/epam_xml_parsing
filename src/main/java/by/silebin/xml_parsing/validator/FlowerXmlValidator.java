package by.silebin.xml_parsing.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.net.URL;

public class FlowerXmlValidator {

    private static final Logger LOGGER = LogManager.getLogger(FlowerXmlValidator.class.getName());
    private static final String SCHEMA_NAME = "xml/schema.xsd";
    private static final URL SCHEMA_URL;

    static {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        SCHEMA_URL = loader.getResource(SCHEMA_NAME);
    }

    public static boolean isValidXml(String xmlPath){
        LOGGER.info("Validating xml file");
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);

        try {
            Schema schema = factory.newSchema(SCHEMA_URL);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(String.valueOf(ClassLoader.getSystemClassLoader().getResource(xmlPath)));
            validator.validate(source);
        } catch (SAXException e) {
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
