package by.silebin.xml_parsing.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum FlowerType {
    GREEN_HOUSE("green house"),
    OPEN_GROUND("open ground");

    private String name;

    private static final Map<String, FlowerType> FLOWER_TYPE_MAP;

    FlowerType (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    static {
        Map<String, FlowerType> map = new HashMap<>();
        for(FlowerType instance : FlowerType.values()){
            map.put(instance.getName().toLowerCase(), instance);
        }
        FLOWER_TYPE_MAP = Collections.unmodifiableMap(map);
    }

    public static FlowerType get(String name){
        return FLOWER_TYPE_MAP.get(name);
    }
}
