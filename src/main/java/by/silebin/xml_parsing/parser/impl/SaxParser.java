package by.silebin.xml_parsing.parser.impl;

import by.silebin.xml_parsing.entity.Flower;
import by.silebin.xml_parsing.entity.Multiplying;
import by.silebin.xml_parsing.entity.Origin;
import by.silebin.xml_parsing.entity.Soil;
import by.silebin.xml_parsing.parser.Parser;
import by.silebin.xml_parsing.parser.exception.SaxParserException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SaxParser implements Parser {


    @Override
    public List<Flower> parse(InputStream inputStream) throws SaxParserException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            FlowerHandler flowerHandler = new FlowerHandler();
            saxParser.parse(inputStream, flowerHandler);
            return flowerHandler.getFlowers();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        throw new SaxParserException();
    }
}

class FlowerHandler extends DefaultHandler {

    private static final String FLOWERS = "flowers";
    private static final String FLOWER = "flower";
    private static final String SOIL = "soil";
    private static final String ORIGIN = "origin";
    private static final String STEM_COLOR = "stemColor";
    private static final String LEAVES_COLOR = "leavesColor";
    private static final String AVERAGE_SIZE = "averageSize";
    private static final String TEMPERATURE = "temperature";
    private static final String PHOTOPHILOUS = "photophilous";
    private static final String WATERING = "watering";
    private static final String MULTIPLYING = "multiplying";


    private List<Flower> flowers;
    private StringBuilder elementValue;
    private Flower.FlowerBuilder flowerBuilder;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName){
            case FLOWERS:
                flowers = new ArrayList<>();
                break;
            case FLOWER:
                flowerBuilder = Flower.newBuilder();
                flowerBuilder.setName(attributes.getValue("name"));
                break;
            case SOIL:
            case ORIGIN:
            case STEM_COLOR:
            case LEAVES_COLOR:
            case AVERAGE_SIZE:
            case TEMPERATURE:
            case PHOTOPHILOUS:
            case WATERING:
            case MULTIPLYING:
                elementValue = new StringBuilder();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case FLOWER:
                flowers.add(flowerBuilder.build());
                break;
            case SOIL:
                flowerBuilder.setSoil(Soil.get(elementValue.toString()));
                break;
            case ORIGIN:
                flowerBuilder.setOrigin(Origin.get(elementValue.toString()));
                break;
            case STEM_COLOR:
                flowerBuilder.setStemColor(elementValue.toString());
                break;
            case LEAVES_COLOR:
                flowerBuilder.setLeavesColor(elementValue.toString());
                break;
            case AVERAGE_SIZE:
                flowerBuilder.setAverageSize(Double.parseDouble(elementValue.toString()));
                break;
            case TEMPERATURE:
                flowerBuilder.setTemperature(Integer.parseInt(elementValue.toString()));
                break;
            case PHOTOPHILOUS:
                flowerBuilder.setPhotophilous(Boolean.parseBoolean(elementValue.toString()));
                break;
            case WATERING:
                flowerBuilder.setWatering(Integer.parseInt(elementValue.toString()));
                break;
            case MULTIPLYING:
                flowerBuilder.setMultiplying(Multiplying.get(elementValue.toString()));
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementValue == null) {
            elementValue = new StringBuilder();
        } else {
            elementValue.append(ch, start, length);
        }
    }

    public List<Flower> getFlowers() {
        return flowers;
    }
}