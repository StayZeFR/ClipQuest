package fr.clipquest.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController extends Controller {

    @FXML
    private Button test;

    @FXML
    private void initialize() {
        this.test.setOnAction(event -> {
            this.window.show("RegisterView");
        });
    }
}
