package by.silebin.xml_parsing.builder;

import by.silebin.xml_parsing.entity.*;
import by.silebin.xml_parsing.exception.UnknownFlowerTypeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.time.YearMonth;

public class DomFlowerBuilder extends AbstractFlowerBuilder {

    private static final Logger LOGGER = LogManager.getLogger(DomFlowerBuilder.class.getName());

    @Override
    public void buildFlowers(InputStream inputStream) {
        LOGGER.info("Parsing xml file using DOM parser");

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputStream);
            Element root = document.getDocumentElement();
            NodeList openGroundFlowers = root.getElementsByTagName(FlowerTags.OPEN_GROUND_FLOWER);
            NodeList greenhouseFlowers = root.getElementsByTagName(FlowerTags.GREENHOUSE_FLOWER);

            for (int i = 0; i < openGroundFlowers.getLength(); i++) {
                Node node = openGroundFlowers.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    flowers.add(createFlower(element, FlowerType.OPEN_GROUND));
                }
            }

            for (int i = 0; i < openGroundFlowers.getLength(); i++) {
                Node node = greenhouseFlowers.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    flowers.add(createFlower(element, FlowerType.GREEN_HOUSE));
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            LOGGER.info(e);
        } catch (UnknownFlowerTypeException e) {
            LOGGER.error("Unknown flower type");
        }
    }

    private Flower createFlower(Element element, FlowerType flowerType) throws UnknownFlowerTypeException {

        String id = element.getAttribute(FlowerTags.ID);
        String name = getTagContent(element, FlowerTags.NAME);
        Soil soil = Soil.get(getTagContent(element, FlowerTags.SOIL));
        Origin origin = Origin.get(getTagContent(element, FlowerTags.ORIGIN));
        String stemColor = getTagContent(element, FlowerTags.STEM_COLOR);
        String leavesColor = getTagContent(element, FlowerTags.LEAVES_COLOR);
        double averageSize = Double.parseDouble(getTagContent(element, FlowerTags.AVERAGE_SIZE));
        int temperature = Integer.parseInt(getTagContent(element, FlowerTags.TEMPERATURE));
        boolean photophilous = Boolean.parseBoolean(getTagContent(element, FlowerTags.PHOTOPHILOUS));
        int watering = Integer.parseInt(getTagContent(element, FlowerTags.WATERING));
        Multiplying multiplying = Multiplying.get(getTagContent(element, FlowerTags.MULTIPLYING));
        YearMonth yearMonth = YearMonth.parse(getTagContent(element, FlowerTags.DATE_PLANTED));

        Flower flower;

        switch (flowerType) {
            case OPEN_GROUND:
                OpenGroundFlower openGroundFlower = new OpenGroundFlower();
                Lifespan lifespan = Lifespan.get(getTagContent(element, FlowerTags.LIFESPAN));
                openGroundFlower.setLifespan(lifespan);
                flower = openGroundFlower;
                break;
            case GREEN_HOUSE:
                GreenHouseFlower greenHouseFlower = new GreenHouseFlower();
                int humidity = Integer.parseInt(getTagContent(element, FlowerTags.HUMIDITY));
                greenHouseFlower.setHumidity(humidity);
                flower = greenHouseFlower;
                break;
            default:
                throw new UnknownFlowerTypeException();
        }

        flower.setId(id);
        flower.setName(name);
        flower.setSoil(soil);
        flower.setOrigin(origin);
        flower.setStemColor(stemColor);
        flower.setLeavesColor(leavesColor);
        flower.setAverageSize(averageSize);
        flower.setTemperature(temperature);
        flower.setPhotophilous(photophilous);
        flower.setWatering(watering);
        flower.setMultiplying(multiplying);
        flower.setPlantDate(yearMonth);
        return flower;
    }

    private String getTagContent(Element element, String tag) {
        String content = element.getElementsByTagName(tag).item(0).getTextContent();
        return content;
    }
}
