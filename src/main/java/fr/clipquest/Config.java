package fr.clipquest;

public enum Config {

    NAME("ClipQuest"),
    VERSION("1.0.0"),
    AUTHOR("ClipQuest Team"),
    CONFIG_FILE("config.properties"),
    CONFIG_PATH(System.getProperty("user.home") + "/.clipquest/");

    private String value;

    private Config(String s) {
        this.value = s;
    }

    public String getValue() {
        return this.value;
    }
}
