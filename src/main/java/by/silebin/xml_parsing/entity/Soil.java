package by.silebin.xml_parsing.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Soil {
    PODZOLIC("podzolic"),
    GROUND("ground"),
    SOD_PODZOLIC("sod-podzolic");

    private String name;

    private static final Map<String, Soil> SOIL_MAP;

    Soil(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    static {
        Map<String, Soil> map = new HashMap<>();
        for(Soil instance : Soil.values()){
            map.put(instance.getName().toLowerCase(), instance);
        }
        SOIL_MAP = Collections.unmodifiableMap(map);
    }

    public static Soil get(String name){
        return SOIL_MAP.get(name.toLowerCase());
    }
}
