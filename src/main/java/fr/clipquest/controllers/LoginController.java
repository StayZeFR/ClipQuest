package fr.clipquest.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoginController extends Controller {

    @FXML
    private ImageView LoginIcon;
    @Override
    public void init() {

        this.render("LoginView");
        // Image image = new Image("file:src/main/resources/fr/clipquest/assets/images/login.png");
        // LoginIcon.setImage(image);

    }
}
