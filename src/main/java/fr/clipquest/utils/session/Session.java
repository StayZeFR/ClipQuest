package fr.clipquest.utils.session;

import fr.clipquest.tools.TokenTool;
import fr.clipquest.utils.ConfigManager;

public class Session {

    private static Session instance;

    private int id;
    private String username;
    private String email;
    private String password;
    private String token;

    public Session(int id, String username, String email, String password, String token) {
        instance = this;
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.token = token;
        this.saveSession();
    }

    private void saveSession() {
        TokenTool.save(this.id, token);
        ConfigManager config = ConfigManager.getInstance();
        config.setProperty("username", this.username);
        config.setProperty("email", this.email);
        config.setProperty("token", this.token);
        config.save();
    }

    public static Session getInstance() {
        return instance;
    }

}
