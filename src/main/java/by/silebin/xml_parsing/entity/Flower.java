package by.silebin.xml_parsing.entity;

import java.time.YearMonth;

public class Flower {

    private static final int DEFAULT_AMOUNT = 1;

    protected FlowerType flowerType;
    private String id;
    private String name;
    private Soil soil;
    private Origin origin;
    private String stemColor;
    private String leavesColor;
    private double averageSize;
    private int temperature;
    private boolean photophilous;
    private int watering;
    private Multiplying multiplying;
    private YearMonth plantDate;
    private int amount = DEFAULT_AMOUNT;

    public Flower() {

    }

    public Flower(FlowerType flowerType,
                  String id, String name,
                  Soil soil, Origin origin,
                  String stemColor,
                  String leavesColor,
                  double averageSize,
                  int temperature,
                  boolean photophilous,
                  int watering,
                  Multiplying multiplying,
                  YearMonth plantDate,
                  int amount) {

        this.flowerType = flowerType;
        this.id = id;
        this.name = name;
        this.soil = soil;
        this.origin = origin;
        this.stemColor = stemColor;
        this.leavesColor = leavesColor;
        this.averageSize = averageSize;
        this.temperature = temperature;
        this.photophilous = photophilous;
        this.watering = watering;
        this.multiplying = multiplying;
        this.plantDate = plantDate;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Soil getSoil() {
        return soil;
    }

    public void setSoil(Soil soil) {
        this.soil = soil;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public String getStemColor() {
        return stemColor;
    }

    public void setStemColor(String stemColor) {
        this.stemColor = stemColor;
    }

    public String getLeavesColor() {
        return leavesColor;
    }

    public void setLeavesColor(String leavesColor) {
        this.leavesColor = leavesColor;
    }

    public double getAverageSize() {
        return averageSize;
    }

    public void setAverageSize(double averageSize) {
        this.averageSize = averageSize;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public boolean isPhotophilous() {
        return photophilous;
    }

    public void setPhotophilous(boolean photophilous) {
        this.photophilous = photophilous;
    }

    public int getWatering() {
        return watering;
    }

    public void setWatering(int watering) {
        this.watering = watering;
    }

    public Multiplying getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(Multiplying multiplying) {
        this.multiplying = multiplying;
    }

    public FlowerType getFlowerType() {
        return flowerType;
    }

    public void setFlowerType(FlowerType flowerType) {
        this.flowerType = flowerType;
    }

    public YearMonth getPlantDate() {
        return plantDate;
    }

    public void setPlantDate(YearMonth plantDate) {
        this.plantDate = plantDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return Double.compare(flower.averageSize, averageSize) == 0 &&
                temperature == flower.temperature &&
                photophilous == flower.photophilous &&
                watering == flower.watering &&
                amount == flower.amount &&
                flowerType == flower.flowerType &&
                id.equals(flower.id) &&
                name.equals(flower.name) &&
                soil == flower.soil &&
                origin == flower.origin &&
                stemColor.equals(flower.stemColor) &&
                leavesColor.equals(flower.leavesColor) &&
                multiplying == flower.multiplying &&
                plantDate.equals(flower.plantDate);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result += id == null ? 0 : id.hashCode();
        result += name == null ? 0 : name.hashCode();
        result += stemColor == null ? 0 : stemColor.hashCode();
        result += leavesColor == null ? 0 : leavesColor.hashCode();
        result += Double.hashCode(averageSize);
        result += Integer.hashCode(temperature);
        result += Boolean.hashCode(photophilous);
        result += Integer.hashCode(watering);
        result += Integer.hashCode(amount);
        return result;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "flowerType=" + flowerType +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", soil=" + soil +
                ", origin=" + origin +
                ", stemColor='" + stemColor + '\'' +
                ", leavesColor='" + leavesColor + '\'' +
                ", averageSize=" + averageSize +
                ", temperature=" + temperature +
                ", photophilous=" + photophilous +
                ", watering=" + watering +
                ", multiplying=" + multiplying +
                ", plantDate=" + plantDate +
                ", amount=" + amount +
                '}';
    }
}

