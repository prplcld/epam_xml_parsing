package by.silebin.xml_parsing.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Multiplying {
    LEAVES("leaves"),
    STALK("stalk"),
    SEED("seed");

    private String name;

    private static final Map<String, Multiplying> MULTIPLYING_MAP;

    Multiplying (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    static {
        Map<String, Multiplying> map = new HashMap<>();
        for(Multiplying instance : Multiplying.values()){
            map.put(instance.getName().toLowerCase(), instance);
        }
        MULTIPLYING_MAP = Collections.unmodifiableMap(map);
    }

    public static Multiplying get(String name){
        return MULTIPLYING_MAP.get(name);
    }
}
