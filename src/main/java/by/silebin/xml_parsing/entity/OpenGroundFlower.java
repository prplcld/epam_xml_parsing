package by.silebin.xml_parsing.entity;

public class OpenGroundFlower extends Flower {

    private Lifespan lifespan;

    public OpenGroundFlower() {
        flowerType = FlowerType.OPEN_GROUND;
    }


    public Lifespan getLifespan() {
        return lifespan;
    }

    public void setLifespan(Lifespan lifespan) {
        this.lifespan = lifespan;
    }
}
