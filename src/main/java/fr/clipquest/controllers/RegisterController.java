package fr.clipquest.controllers;

import fr.clipquest.models.dao.UserDAO;
import fr.clipquest.models.entities.UserEntity;
import fr.clipquest.tools.HashTool;
import fr.clipquest.tools.TokenTool;
import fr.clipquest.utils.session.Session;
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

public class RegisterController extends Controller {

    @FXML
    private Label errorLabel;
    @FXML
    private Label alreadyConnected;
    @FXML
    private ImageView eyeIcon;
    @FXML
    private ImageView confirmEyeIcon;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private TextField passwordVisibleField;
    @FXML
    private TextField confirmPasswordVisibleField;
    @FXML
    private Button registerButton;

    @FXML
    public void initialize() {

        this.alreadyConnected.setOnMouseClicked(event -> {
            this.window.show("LoginView");
        });

        this.eyeIcon.setImage(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/fr/clipquest/assets/images/eye.png"))));

        this.confirmEyeIcon.setImage(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/fr/clipquest/assets/images/eye.png"))));

        DropShadow shadow = new DropShadow();
        this.eyeIcon.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> eyeIcon.setEffect(shadow));
        this.eyeIcon.addEventHandler(MouseEvent.MOUSE_EXITED, event -> eyeIcon.setEffect(null));
        this.confirmEyeIcon.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> confirmEyeIcon.setEffect(shadow));
        this.confirmEyeIcon.addEventHandler(MouseEvent.MOUSE_EXITED, event -> confirmEyeIcon.setEffect(null));

        this.registerButton.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> registerButton.setStyle("-fx-background-color: #16a085;"));
        this.registerButton.addEventHandler(MouseEvent.MOUSE_EXITED, event -> registerButton.setStyle("-fx-background-color: #1abc9c;"));

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

        this.confirmEyeIcon.setOnMouseClicked(event -> {
            if (this.confirmPasswordField.isVisible()) {
                this.confirmEyeIcon.setImage(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/fr/clipquest/assets/images/hidden.png"))));
                this.confirmPasswordField.setVisible(false);
                this.confirmPasswordVisibleField.setVisible(true);
                this.confirmPasswordVisibleField.setText(this.passwordField.getText());
                this.confirmPasswordVisibleField.requestFocus();
                this.confirmPasswordVisibleField.positionCaret(this.passwordField.getText().length());
            } else {
                this.confirmEyeIcon.setImage(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/fr/clipquest/assets/images/eye.png"))));
                this.confirmPasswordField.setVisible(true);
                this.confirmPasswordVisibleField.setVisible(false);
                this.confirmPasswordField.setText(this.passwordVisibleField.getText());
                this.confirmPasswordField.requestFocus();
                this.confirmPasswordField.positionCaret(this.passwordField.getText().length());
            }
        });
    }

    private void showErrorMessage(String message) {
        this.errorLabel.setText(message);
        this.errorLabel.setVisible(true);
    }

    @FXML
    private void register() {
        String username = this.usernameField.getText().trim();
        String email = this.emailField.getText().trim();
        String password = (this.passwordField.isVisible() ? this.passwordField.getText() : this.passwordVisibleField.getText()).trim();
        String confirmPassword = (this.confirmPasswordField.isVisible() ? this.confirmPasswordField.getText() : this.confirmPasswordVisibleField.getText()).trim();

        if (!(username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty())) {
            if (password.equals(confirmPassword)) {
                UserDAO dao = new UserDAO();
                if (dao.get("username", username).isEmpty() && dao.get("email", email).isEmpty()) {
                    UserEntity user = new UserEntity(username, email, HashTool.hash(password));
                    dao.create(user);
                    user = dao.get("username", username).getFirst();
                    new Session(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), TokenTool.generate());
                    this.window.show("HomeView");
                } else {
                    this.showErrorMessage("User already exists!");
                }
            } else {
                this.showErrorMessage("Passwords do not match!");
            }
        } else {
            this.showErrorMessage("Please fill all fields!");
        }
    }
}
