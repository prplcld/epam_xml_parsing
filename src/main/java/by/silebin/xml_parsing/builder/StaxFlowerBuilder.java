package by.silebin.xml_parsing.builder;

import by.silebin.xml_parsing.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.InputStream;
import java.time.YearMonth;

public class StaxFlowerBuilder extends AbstractFlowerBuilder {

    private static final Logger LOGGER = LogManager.getLogger(StaxFlowerBuilder.class.getName());

    private Flower flower;
    private StringBuilder elementValue;
    private Attribute amount;

    @Override
    public void buildFlowers(InputStream inputStream) {
        LOGGER.info("Parsing xml file using StAX parser");

        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        try {
            XMLEventReader eventReader = xmlInputFactory.createXMLEventReader(inputStream);
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                switch (event.getEventType()) {
                    case XMLEvent.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();

                        switch (qName) {
                            case FlowerTags.GREENHOUSE_FLOWER:
                                flower = new GreenHouseFlower();

                                flower.setId(startElement.getAttributeByName(QName.valueOf(FlowerTags.ID)).getValue());
                                amount = startElement.getAttributeByName(QName.valueOf(FlowerTags.AMOUNT));
                                if(amount != null && amount.isSpecified()){
                                    flower.setAmount(Integer.parseInt(amount.getValue()));
                                }
                                break;
                            case FlowerTags.OPEN_GROUND_FLOWER:
                                flower = new OpenGroundFlower();
                                flower.setId(startElement.getAttributeByName(QName.valueOf(FlowerTags.ID)).getValue());
                                amount = startElement.getAttributeByName(QName.valueOf(FlowerTags.AMOUNT));
                                if(amount != null && amount.isSpecified()){
                                    flower.setAmount(Integer.parseInt(amount.getValue()));
                                }
                                break;
                            default:
                                elementValue = new StringBuilder();
                                break;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        if (elementValue == null) {
                            elementValue = new StringBuilder();
                        } else {
                            Characters characters = event.asCharacters();
                            elementValue.append(characters.getData());
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();
                        String endElementName = endElement.getName().getLocalPart();

                        switch (endElementName) {
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
            }
        } catch (XMLStreamException e) {
            LOGGER.error(e);
        }
    }
}
