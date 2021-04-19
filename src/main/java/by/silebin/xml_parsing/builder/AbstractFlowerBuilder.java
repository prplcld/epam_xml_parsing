package by.silebin.xml_parsing.builder;

import by.silebin.xml_parsing.entity.Flower;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractFlowerBuilder {
    protected Set<Flower> flowers;

    public AbstractFlowerBuilder() {
        flowers = new HashSet<>();
    }

    public AbstractFlowerBuilder(Set<Flower> flowers) {
        this.flowers = flowers;
    }

    public Set<Flower> getFlowers() {
        return flowers;
    }

    public abstract void buildFlowers(InputStream inputStream);
}
