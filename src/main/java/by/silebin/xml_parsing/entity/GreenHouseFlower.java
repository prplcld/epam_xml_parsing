package by.silebin.xml_parsing.entity;

public class GreenHouseFlower extends Flower {
    private int humidity;

    public GreenHouseFlower() {
        flowerType = FlowerType.GREEN_HOUSE;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

}
