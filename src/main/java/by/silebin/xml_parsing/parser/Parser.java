package by.silebin.xml_parsing.parser;

import by.silebin.xml_parsing.entity.Flower;
import by.silebin.xml_parsing.parser.exception.SaxParserException;

import java.io.InputStream;
import java.util.List;

public interface Parser {
    List<Flower> parse(InputStream inputStream) throws SaxParserException;
}
