package fr.clipquest.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RegisterController extends Controller {

    @FXML
    private Label alreadyConnected;

    public RegisterController() {
        super("RegisterView");
    }

    @Override
    public void init() {
        this.alreadyConnected.setOnMouseClicked(event -> {
            this.window.show(LoginController.class);
        });
    }

    @Override
    protected Controller getInstance() {
        return this;
    }
}
