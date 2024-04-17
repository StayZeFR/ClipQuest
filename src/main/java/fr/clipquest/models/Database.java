package fr.clipquest.models;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private static Connection connection;

    // TODO: A sécuriser
    private static String USER = "root";
    private static String PASSWORD = "";

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/clipquest";
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, USER, PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

}
