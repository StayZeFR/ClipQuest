package fr.clipquest.controllers;

import fr.clipquest.Window;
import fr.clipquest.controllers.components.WindowControlsController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;

public class HomeController extends Controller {

    @FXML
    private void initialize() {
        System.out.println(this.session.getCurrentView());
        //this.windowControlsController.coucou();
    }
}
