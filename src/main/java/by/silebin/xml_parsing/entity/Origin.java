package by.silebin.xml_parsing.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Origin {
    EUROPE("Europe"),
    ASIA("Asia"),
    AFRICA("Africa"),
    NORTH_AMERICA("North America"),
    SOUTH_AMERICA("South America"),
    AUSTRALIA("Australia");

    private String name;

    private static final Map<String, Origin> ORIGIN_MAP;

    Origin (String name){
        this. name = name;
    }

    public String getName() {
        return name;
    }

    static {
        Map<String, Origin> map = new HashMap<>();
        for(Origin instance : Origin.values()){
            map.put(instance.getName().toLowerCase(), instance);
        }
        ORIGIN_MAP = Collections.unmodifiableMap(map);
    }

    public static Origin get(String name){
        return ORIGIN_MAP.get(name.toLowerCase());
    }
}
