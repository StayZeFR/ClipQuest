package fr.clipquest.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Objects;

public class LoginController extends Controller {

    @FXML
    private Label stillNotConnected;
    @FXML
    private ImageView eyeIcon;

    @FXML
    private PasswordField passwordField;


    public LoginController() {
        super("LoginView");
    }

    @Override
    public void init() {
        this.stillNotConnected.setOnMouseClicked(event -> {
            this.window.show(RegisterController.class);
        });

        eyeIcon.setImage(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/fr/clipquest/assets/images/eye.png"))));

        // Ajouter l'effet d'ombre
        DropShadow shadow = new DropShadow();
        eyeIcon.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> eyeIcon.setEffect(shadow));
        eyeIcon.addEventHandler(MouseEvent.MOUSE_EXITED, event -> eyeIcon.setEffect(null));


    }

    @Override
    protected Controller getInstance() {
        return this;
    }
}
