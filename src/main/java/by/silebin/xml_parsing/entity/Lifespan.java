package by.silebin.xml_parsing.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Lifespan {
    ANNUAL("annual"),
    BIENNIAL("biennial"),
    PERENNIAL("perennial");

    private String name;

    private static final Map<String, Lifespan> LIFESPAN_MAP;

    Lifespan (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    static {
        Map<String, Lifespan> map = new HashMap<>();
        for(Lifespan instance : Lifespan.values()){
            map.put(instance.getName().toLowerCase(), instance);
        }
        LIFESPAN_MAP = Collections.unmodifiableMap(map);
    }

    public static Lifespan get(String name){
        return LIFESPAN_MAP.get(name);
    }
}
