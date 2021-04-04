package by.silebin.xml_parsing.entity;

public class Flower {

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

    private Flower() {

    }

    public String getName() {
        return name;
    }

    public Soil getSoil() {
        return soil;
    }

    public Origin getOrigin() {
        return origin;
    }

    public String getStemColor() {
        return stemColor;
    }

    public String getLeavesColor() {
        return leavesColor;
    }

    public double getAverageSize() {
        return averageSize;
    }

    public int getTemperature() {
        return temperature;
    }

    public boolean isPhotophilous() {
        return photophilous;
    }

    public int getWatering() {
        return watering;
    }

    public Multiplying getMultiplying() {
        return multiplying;
    }

    public static FlowerBuilder newBuilder(){
        return new Flower().new FlowerBuilder();
    }

    public class FlowerBuilder {

        private FlowerBuilder() {

        }

        public FlowerBuilder setName(String name){
            Flower.this.name = name;
            return this;
        }

        public FlowerBuilder setSoil(Soil soil){
            Flower.this.soil = soil;
            return this;
        }

        public FlowerBuilder setOrigin(Origin origin){
            Flower.this.origin = origin;
            return this;
        }

        public FlowerBuilder setStemColor(String color){
            Flower.this.stemColor = color;
            return this;
        }

        public FlowerBuilder setLeavesColor(String color){
            Flower.this.leavesColor = color;
            return this;
        }

        public FlowerBuilder setMultiplying(Multiplying multiplying){
            Flower.this.multiplying = multiplying;
            return this;
        }

        public FlowerBuilder setAverageSize(double size){
            Flower.this.averageSize = size;
            return this;
        }

        public FlowerBuilder setTemperature(int temperature){
            Flower.this.temperature = temperature;
            return this;
        }

        public FlowerBuilder setPhotophilous(boolean photophilous){
            Flower.this.photophilous = photophilous;
            return this;
        }

        public FlowerBuilder setWatering(int watering){
            Flower.this.watering = watering;
            return this;
        }

        public Flower build(){
            return Flower.this;
        }
    }
}

