package fr.clipquest.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Objects;

public class HomeController extends Controller {
    @Override
    public void view() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/fr/clipquest/views/HomeView.fxml")));
            this.window.setScene(new Scene(root));
            this.window.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
