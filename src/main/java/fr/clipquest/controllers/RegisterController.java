package fr.clipquest.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Objects;

public class RegisterController extends Controller {

    @FXML
    private Label alreadyConnected;
    @FXML
    private ImageView passwordFieldEyeIcon;
    @FXML
    private ImageView confirmPasswordFieldEyeIcon;
    @FXML
    private Button registerButton;

    @FXML
    public void initialize() {
        this.alreadyConnected.setOnMouseClicked(event -> {
            this.window.show("LoginView");
        });

        this.passwordFieldEyeIcon.setImage(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/fr/clipquest/assets/images/eye.png"))));

        this.confirmPasswordFieldEyeIcon.setImage(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/fr/clipquest/assets/images/eye.png"))));

        // Ajouter l'effet d'ombre
        DropShadow shadow = new DropShadow();
        this.passwordFieldEyeIcon.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> passwordFieldEyeIcon.setEffect(shadow));
        this.passwordFieldEyeIcon.addEventHandler(MouseEvent.MOUSE_EXITED, event -> passwordFieldEyeIcon.setEffect(null));
        this.confirmPasswordFieldEyeIcon.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> confirmPasswordFieldEyeIcon.setEffect(shadow));
        this.confirmPasswordFieldEyeIcon.addEventHandler(MouseEvent.MOUSE_EXITED, event -> confirmPasswordFieldEyeIcon.setEffect(null));

        this.registerButton.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> registerButton.setStyle("-fx-background-color: #16a085;"));
        this.registerButton.addEventHandler(MouseEvent.MOUSE_EXITED, event -> registerButton.setStyle("-fx-background-color: #1abc9c;"));


    }
}
