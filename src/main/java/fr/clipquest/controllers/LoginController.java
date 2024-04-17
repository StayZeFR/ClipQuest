package fr.clipquest.controllers;

import fr.clipquest.models.dao.UserDAO;
import fr.clipquest.models.entities.UserEntity;
import fr.clipquest.tools.HashTool;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.List;
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
    private Button loginButton;

    @FXML
    public void initialize() {
        this.eyeIcon.setImage(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/fr/clipquest/assets/images/eye.png"))));

        DropShadow shadow = new DropShadow();
        this.eyeIcon.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> eyeIcon.setEffect(shadow));
        this.eyeIcon.addEventHandler(MouseEvent.MOUSE_EXITED, event -> eyeIcon.setEffect(null));

        this.loginButton.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> loginButton.setStyle("-fx-background-color: #16a085;"));
        this.loginButton.addEventHandler(MouseEvent.MOUSE_EXITED, event -> loginButton.setStyle("-fx-background-color: #1abc9c;"));

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
            if (event.getCode().toString().equals("ENTER") || event.getCode().toString().equals("TAB")) {
                this.passwordField.requestFocus();
                this.passwordField.positionCaret(this.passwordField.getText().length());
            }
        });

        this.stillNotConnected.setOnMouseClicked(event -> {
            this.window.show("RegisterView");
        });
    }

    public void login() {
        String username = this.usernameField.getText();
        String password = this.passwordField.getText();
        System.out.println("Username: " + username + " Password: " + password);
        if (!username.isEmpty() || !password.isEmpty()) {
            UserDAO userDAO = new UserDAO();
            List<UserEntity> users = userDAO.get("username", username);
            if (!users.isEmpty()) {
                UserEntity user = users.getFirst();
                if (HashTool.check(password, user.getPassword())) {
                    this.window.show("HomeView");
                } else {
                    // TODO : Error message
                    System.out.println("Invalid password");
                }
            } else {
                // TODO : Error message
                System.out.println("Invalid username");
            }
        }
    }

}
