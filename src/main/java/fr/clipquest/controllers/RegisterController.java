package fr.clipquest.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RegisterController extends Controller {

    @FXML
    private Label alreadyConnected;

    @FXML
    public void initialize() {
        this.alreadyConnected.setOnMouseClicked(event -> {
            this.window.show("LoginView");
        });
    }
}
