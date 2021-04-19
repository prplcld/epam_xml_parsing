package by.silebin.xml_parsing.builder;

import by.silebin.xml_parsing.entity.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.time.YearMonth;
import java.util.HashSet;
import java.util.Set;

public class FlowerBuilderTest {

    private static final Set<Flower> expected = new HashSet<>();
    private InputStream xml;

    static {
        for(int i = 1; i <= 8; i++){
            expected.add(new GreenHouseFlower("id-" +  i,
                    "flower" + i,
                    Soil.PODZOLIC,
                    Origin.ASIA,
                    "blue",
                    "blue",
                    i,
                    i,
                    true,
                    i,
                    Multiplying.LEAVES,
                    YearMonth.parse("2019-10"),
                    i % 2 == 1 ? 2 : 1,
                    i));
        }
        for (int i = 9; i <= 16; i++){
            expected.add(new OpenGroundFlower("id-" +  i,
                    "flower" + i,
                    Soil.PODZOLIC,
                    Origin.EUROPE,
                    "green",
                    "green",
                    i,
                    i,
                    false,
                    i,
                    Multiplying.LEAVES,
                    YearMonth.parse("2019-10"),
                    i % 2 == 1 ? 2 : 1,
                    Lifespan.ANNUAL));
        }
    }


    @Test
    public void testDomBuilder(){
        AbstractFlowerBuilder abstractFlowerBuilder = new DomFlowerBuilder();
        abstractFlowerBuilder.buildFlowers(ClassLoader.getSystemClassLoader().getResourceAsStream("xml/example.xml"));
        Assert.assertEquals(abstractFlowerBuilder.getFlowers(), expected);
    }

    @Test
    public void testSaxBuilder(){
        AbstractFlowerBuilder abstractFlowerBuilder = new SaxFlowerBuilder();
        abstractFlowerBuilder.buildFlowers(ClassLoader.getSystemClassLoader().getResourceAsStream("xml/example.xml"));
        Assert.assertEquals(abstractFlowerBuilder.getFlowers(), expected);
    }

    @Test
    public void testStaxBuilder(){
        AbstractFlowerBuilder abstractFlowerBuilder = new StaxFlowerBuilder();
        abstractFlowerBuilder.buildFlowers(ClassLoader.getSystemClassLoader().getResourceAsStream("xml/example.xml"));
        Assert.assertEquals(abstractFlowerBuilder.getFlowers(), expected);
    }
}
