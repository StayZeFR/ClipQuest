package fr.clipquest.controllers;

import fr.clipquest.Window;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Objects;

public abstract class Controller {

    protected Window window;

    public Controller() {
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    /**
     * Render a view
     *
     * @param view The view to render
     */
    protected void render(String view) {
        String path = "/fr/clipquest/views/" + view + ".fxml";
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource(path)));
            this.window.setScene(new Scene(root));
            this.window.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public abstract void init();

}
