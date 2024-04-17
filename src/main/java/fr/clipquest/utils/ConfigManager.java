package fr.clipquest.utils;

import java.io.*;
import java.util.Properties;

public class ConfigManager {

    private static ConfigManager instance;

    private final Properties properties;
    private final String path;

    public ConfigManager(String path) {
        instance = this;
        this.path = path;
        properties = new Properties();
        this.loadConfig();
    }

    private void loadConfig() {
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
                this.setDefaultConfig();
            }
            InputStream input = new FileInputStream(path);
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setDefaultConfig() {
        this.properties.setProperty("username", "");
        this.properties.setProperty("email", "");
        this.properties.setProperty("token", "");
        this.saveConfig();
    }

    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }

    public void setProperty(String key, String value) {
        this.properties.setProperty(key, value);
    }

    public boolean containsKey(String key) {
        return this.properties.containsKey(key);
    }

    public void saveConfig() {
        try (OutputStream output = new FileOutputStream(path)) {
            properties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigManager getInstance() {
        return instance;
    }

}
