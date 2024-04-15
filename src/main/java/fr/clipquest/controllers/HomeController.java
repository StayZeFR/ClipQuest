package fr.clipquest.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController extends Controller {

    @FXML
    private Button test;

    public HomeController() {
        super("HomeView");
    }

    @Override
    public void init() {
        this.test.setOnAction(event -> {
            this.window.show(RegisterController.class);
        });
    }

    @Override
    protected Controller getInstance() {
        return this;
    }
}
