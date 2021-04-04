package by.silebin.xml_parsing.parser.impl;

import by.silebin.xml_parsing.entity.Flower;
import by.silebin.xml_parsing.entity.Multiplying;
import by.silebin.xml_parsing.entity.Origin;
import by.silebin.xml_parsing.entity.Soil;
import by.silebin.xml_parsing.parser.Parser;
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
import java.util.ArrayList;
import java.util.List;

public class DomParser implements Parser {

    @Override
    public List<Flower> parse(InputStream inputStream) {
        List<Flower> flowers = new ArrayList<>();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputStream);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("flower");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    flowers.add(createFlower(element));
                }
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return flowers;
    }

    private Flower createFlower(Element element) {
        Flower.FlowerBuilder flowerBuilder = Flower.newBuilder();
        flowerBuilder.setName(element.getAttribute("name"))
                .setOrigin(Origin.get(element.getElementsByTagName("origin").item(0).getTextContent()))
                .setSoil(Soil.get(element.getElementsByTagName("soil").item(0).getTextContent()))
                .setStemColor(element.getElementsByTagName("stemColor").item(0).getTextContent())
                .setLeavesColor(element.getElementsByTagName("leavesColor").item(0).getTextContent())
                .setAverageSize(Double.parseDouble(element.getElementsByTagName("averageSize").item(0).getTextContent()))
                .setTemperature(Integer.parseInt(element.getElementsByTagName("temperature").item(0).getTextContent()))
                .setPhotophilous(Boolean.parseBoolean(element.getElementsByTagName("photophilous").item(0).getTextContent()))
                .setWatering(Integer.parseInt(element.getElementsByTagName("watering").item(0).getTextContent()))
                .setMultiplying(Multiplying.get(element.getElementsByTagName("multiplying").item(0).getTextContent()));
        Flower flower = flowerBuilder.build();
        return flower;
    }
}
