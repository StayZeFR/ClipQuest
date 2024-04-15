package fr.clipquest.controllers;

import fr.clipquest.Window;
import fr.clipquest.utils.Parameters;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public abstract class Controller {

    protected Parameters parameters;
    protected Window window;
    protected String view;

    public Controller(String view) {
        this.view = view;
    }

    public void initialize(Window window, Parameters parameters) {
        this.parameters = parameters;
        this.window = window;
        if (!this.view.isEmpty()) {
            this.render(this.view);
        }
        this.init();
    }

    public void initialize(Window window) {
        this.initialize(window, new Parameters());
    }

    /**
     * Render a view
     *
     * @param view The view to render
     */
    private void render(String view) {
        String path = "/fr/clipquest/views/" + view + ".fxml";
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource(path));
            loader.setController(this.getInstance());
            Parent root = loader.load();
            this.window.setScene(new Scene(root));
            this.window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void init();
    protected abstract Controller getInstance();

}
