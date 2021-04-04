package by.silebin;

import by.silebin.xml_parsing.entity.Flower;
import by.silebin.xml_parsing.parser.Parser;
import by.silebin.xml_parsing.parser.exception.SaxParserException;
import by.silebin.xml_parsing.parser.impl.DomParser;
import by.silebin.xml_parsing.parser.impl.SaxParser;

public class App 
{
    public static void main( String[] args ) throws SaxParserException {
        Parser parser = new SaxParser();
        for(Flower f :parser.parse(ClassLoader.getSystemClassLoader().getResourceAsStream("xml/example.xml"))){
            System.out.println(f.getOrigin().toString());
        }
    }
}
