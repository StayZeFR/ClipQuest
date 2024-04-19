package fr.clipquest.utils.session;

import fr.clipquest.Config;
import fr.clipquest.models.dao.TokenDAO;
import fr.clipquest.tools.TokenTool;
import fr.clipquest.utils.ConfigManager;
import fr.clipquest.utils.ScreenRecorder;
import org.bytedeco.javacv.FrameRecorder;

import java.awt.*;

public class Session {

    private static Session instance;

    private int id;
    private String username;
    private String email;
    private String password;
    private String token;
    private boolean isLogged;
    private String currentView;
    private ScreenRecorder recorder;

    public Session() {
        instance = this;
        this.load();
        TokenDAO dao = new TokenDAO();
        this.isLogged = (!this.token.isEmpty() && dao.checkToken(this.id, this.token));
        try {
            this.recorder = new ScreenRecorder();
            this.recorder.start(30);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void load() {
        ConfigManager config = ConfigManager.getInstance();
        this.id = Integer.parseInt(config.getProperty("id"));
        this.username = config.getProperty("username");
        this.email = config.getProperty("email");
        this.token = config.getProperty("token");
    }

    public void create(int id, String username, String email, String password, String token) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.token = token;
        this.isLogged = true;
        TokenTool.save(this.id, token);
        this.save();
    }

    public boolean isLogged() {
        return this.isLogged;
    }

    public void setCurrentView(String view) {
        this.currentView = view;
    }

    public String getCurrentView() {
        return this.currentView;
    }

    private void save() {
        TokenTool.save(this.id, token);
        ConfigManager config = ConfigManager.getInstance();
        config.setProperty("id", String.valueOf(this.id));
        config.setProperty("username", this.username);
        config.setProperty("email", this.email);
        config.setProperty("token", this.token);
        config.save();
    }

    public void destroy() {
        // TODO
    }

    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getToken() {
        return this.token;
    }

    public ScreenRecorder getRecorder() {
        return this.recorder;
    }

    public static Session getInstance() {
        return instance;
    }

}
