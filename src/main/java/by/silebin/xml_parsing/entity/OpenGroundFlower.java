package by.silebin.xml_parsing.entity;

import java.time.YearMonth;

public class OpenGroundFlower extends Flower {

    private Lifespan lifespan;

    public OpenGroundFlower() {
        flowerType = FlowerType.OPEN_GROUND;
    }

    public OpenGroundFlower(String id,
                            String name,
                            Soil soil,
                            Origin origin,
                            String stemColor,
                            String leavesColor,
                            double averageSize,
                            int temperature,
                            boolean photophilous,
                            int watering,
                            Multiplying multiplying,
                            YearMonth plantDate,
                            int amount,
                            Lifespan lifespan) {
        super(FlowerType.OPEN_GROUND, id, name, soil, origin, stemColor, leavesColor, averageSize, temperature, photophilous, watering, multiplying, plantDate, amount);
        this.lifespan = lifespan;
    }

    public Lifespan getLifespan() {
        return lifespan;
    }

    public void setLifespan(Lifespan lifespan) {
        this.lifespan = lifespan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OpenGroundFlower that = (OpenGroundFlower) o;
        return lifespan == that.lifespan;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result += lifespan == null ? 1 : lifespan.hashCode();
        return result;
    }

    @Override
    public String toString() {
        String result = super.toString();

        return result + "(OpenGroundFlower{" +
                "lifespan=" + lifespan +
                "})";
    }
}
