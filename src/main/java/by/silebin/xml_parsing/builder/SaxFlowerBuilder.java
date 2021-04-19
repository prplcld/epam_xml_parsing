package by.silebin.xml_parsing.builder;

import by.silebin.xml_parsing.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.time.YearMonth;

public class SaxFlowerBuilder extends AbstractFlowerBuilder {

    public static final Logger LOGGER = LogManager.getLogger(SaxFlowerBuilder.class.getName());


    @Override
    public void buildFlowers(InputStream inputStream) {

        LOGGER.info("Parsing xml file using SAX parser");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            FlowerHandler flowerHandler = new FlowerHandler();
            saxParser.parse(inputStream, flowerHandler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            LOGGER.error(e);
        }
    }

    class FlowerHandler extends DefaultHandler {

        private StringBuilder elementValue;
        private Flower flower;
        private String amount = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            switch (qName) {
                case FlowerTags.GREENHOUSE_FLOWER:
                    flower = new GreenHouseFlower();
                    flower.setId(attributes.getValue(FlowerTags.ID));
                    amount = attributes.getValue(FlowerTags.AMOUNT);
                    if(amount != null &&!amount.isBlank()){
                        flower.setAmount(Integer.parseInt(amount));
                    }
                    break;
                case FlowerTags.OPEN_GROUND_FLOWER:
                    flower = new OpenGroundFlower();
                    flower.setId(attributes.getValue(FlowerTags.ID));
                    amount = attributes.getValue(FlowerTags.AMOUNT);
                    if(amount != null && !amount.isBlank()){
                        flower.setAmount(Integer.parseInt(amount));
                    }
                    break;
                default:
                    elementValue = new StringBuilder();
                    break;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            switch (qName) {
                case FlowerTags.GREENHOUSE_FLOWER:
                case FlowerTags.OPEN_GROUND_FLOWER:
                    flowers.add(flower);
                    break;
                case FlowerTags.NAME:
                    flower.setName(elementValue.toString());
                    break;
                case FlowerTags.SOIL:
                    flower.setSoil(Soil.get(elementValue.toString()));
                    break;
                case FlowerTags.ORIGIN:
                    flower.setOrigin(Origin.get(elementValue.toString()));
                    break;
                case FlowerTags.STEM_COLOR:
                    flower.setStemColor(elementValue.toString());
                    break;
                case FlowerTags.LEAVES_COLOR:
                    flower.setLeavesColor(elementValue.toString());
                    break;
                case FlowerTags.AVERAGE_SIZE:
                    flower.setAverageSize(Double.parseDouble(elementValue.toString()));
                    break;
                case FlowerTags.TEMPERATURE:
                    flower.setTemperature(Integer.parseInt(elementValue.toString()));
                    break;
                case FlowerTags.PHOTOPHILOUS:
                    flower.setPhotophilous(Boolean.parseBoolean(elementValue.toString()));
                    break;
                case FlowerTags.WATERING:
                    flower.setWatering(Integer.parseInt(elementValue.toString()));
                    break;
                case FlowerTags.MULTIPLYING:
                    flower.setMultiplying(Multiplying.get(elementValue.toString()));
                    break;
                case FlowerTags.DATE_PLANTED:
                    flower.setPlantDate(YearMonth.parse(elementValue.toString()));
                    break;
                case FlowerTags.HUMIDITY:
                    GreenHouseFlower greenHouseFlower = (GreenHouseFlower) flower;
                    greenHouseFlower.setHumidity(Integer.parseInt(elementValue.toString()));
                    break;
                case FlowerTags.LIFESPAN:
                    OpenGroundFlower openGroundFlower = (OpenGroundFlower) flower;
                    openGroundFlower.setLifespan(Lifespan.get(elementValue.toString()));
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
    }
}
