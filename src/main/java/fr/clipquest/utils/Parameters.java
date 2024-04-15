package fr.clipquest.utils;

import java.util.HashMap;
import java.util.Map;

public class Parameters {

    private Map<String, Object> parameters;

    public Parameters() {
        this.parameters = new HashMap<>();
    }

    public void add(String key, Object value) {
        this.parameters.put(key, value);
    }

    public Object get(String key) {
        return this.parameters.get(key);
    }

    public void remove(String key) {
        this.parameters.remove(key);
    }

}
