package by.silebin;

import by.silebin.xml_parsing.builder.AbstractFlowerBuilder;
import by.silebin.xml_parsing.builder.DomFlowerBuilder;
import by.silebin.xml_parsing.builder.SaxFlowerBuilder;
import by.silebin.xml_parsing.builder.StaxFlowerBuilder;
import by.silebin.xml_parsing.entity.Flower;
import by.silebin.xml_parsing.validator.FlowerXmlValidator;

public class App
{
    public static void main( String[] args ) {
        AbstractFlowerBuilder abstractFlowerBuilder = new StaxFlowerBuilder();
        abstractFlowerBuilder.buildFlowers(ClassLoader.getSystemClassLoader().getResourceAsStream("xml/example.xml"));
        for (Flower f : abstractFlowerBuilder.getFlowers()){
            System.out.println(f.getId());
        }
        System.out.println(FlowerXmlValidator.isValidXml("xml/example.xml"));
    }
}
