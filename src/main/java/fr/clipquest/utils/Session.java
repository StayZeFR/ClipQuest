package fr.clipquest.utils;

public class Session {

    private static Session instance;

    private String username;
    private String email;
    private String password;

    public Session(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        instance = this;
    }

    public static Session getInstance() {
        return instance;
    }

}
