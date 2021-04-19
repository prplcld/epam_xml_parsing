package by.silebin.xml_parsing.entity;

import java.time.YearMonth;

public class GreenHouseFlower extends Flower {

    private int humidity;

    public GreenHouseFlower() {
        flowerType = FlowerType.GREEN_HOUSE;
    }

    public GreenHouseFlower(String id, String name,
                            Soil soil, Origin origin,
                            String stemColor,
                            String leavesColor,
                            double averageSize,
                            int temperature,
                            boolean photophilous,
                            int watering,
                            Multiplying multiplying,
                            YearMonth plantDate,
                            int amount,
                            int humidity) {

        super(FlowerType.GREEN_HOUSE, id, name, soil, origin, stemColor, leavesColor, averageSize, temperature, photophilous, watering, multiplying, plantDate, amount);
        this.humidity = humidity;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GreenHouseFlower that = (GreenHouseFlower) o;
        return humidity == that.humidity;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result += Integer.hashCode(humidity);
        return result;
    }

    @Override
    public String toString() {
        String result = super.toString();

        return result + "(GreenHouseFlower{" +
                "humidity=" + humidity +
                "})";
    }
}
