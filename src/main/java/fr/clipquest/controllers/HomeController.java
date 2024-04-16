package fr.clipquest.controllers;

import fr.clipquest.Window;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;

public class HomeController extends Controller {

    @FXML
    private Button test;

    @FXML
    private void initialize() {
        this.test.setOnAction(event -> {
            window.show("RegisterView");
        });
    }
}
