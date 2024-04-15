package fr.clipquest.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField passwordVisibleField;

    @FXML
    public void initialize() {
        this.eyeIcon.setImage(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/fr/clipquest/assets/images/eye.png"))));

        // Ajouter l'effet d'ombre
        DropShadow shadow = new DropShadow();
        this.eyeIcon.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> eyeIcon.setEffect(shadow));
        this.eyeIcon.addEventHandler(MouseEvent.MOUSE_EXITED, event -> eyeIcon.setEffect(null));

        this.eyeIcon.setOnMouseClicked(event -> {
            if (this.passwordField.isVisible()) {
                this.eyeIcon.setImage(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/fr/clipquest/assets/images/hidden.png"))));
                this.passwordField.setVisible(false);
                this.passwordVisibleField.setVisible(true);
                this.passwordVisibleField.setText(this.passwordField.getText());
                this.passwordVisibleField.requestFocus();
                this.passwordVisibleField.positionCaret(this.passwordField.getText().length());
            } else {
                this.eyeIcon.setImage(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/fr/clipquest/assets/images/eye.png"))));
                this.passwordField.setVisible(true);
                this.passwordVisibleField.setVisible(false);
                this.passwordField.setText(this.passwordVisibleField.getText());
                this.passwordField.requestFocus();
                this.passwordField.positionCaret(this.passwordField.getText().length());
            }
        });

        this.usernameField.setOnKeyPressed(event -> {
            if (event.getCode().toString().equals("ENTER")) {
                this.passwordField.requestFocus();
                this.passwordField.positionCaret(this.passwordField.getText().length());
            }
        });

        this.stillNotConnected.setOnMouseClicked(event -> {
            this.window.show("RegisterView");
        });

    }
}
