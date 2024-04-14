package fr.clipquest.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Objects;

public class HomeController extends Controller {
    @Override
    public void view() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/fr/clipquest/views/HomeView.fxml")));
            this.scene.setRoot(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
