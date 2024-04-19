package fr.clipquest.controllers.components;

import fr.clipquest.controllers.Controller;
import fr.clipquest.utils.session.Session;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;

import java.util.Objects;

public class WindowControlsController extends Controller {

    @FXML
    private ImageView closeIcon;
    @FXML
    private ImageView minimizeIcon;
    @FXML
    private ImageView settingsIcon;
    @FXML
    private ImageView homeIcon;

    @FXML
    private void initialize() {
        this.closeIcon.setImage(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/fr/clipquest/assets/images/close.png"))));
        this.closeIcon.setOnMouseClicked(event -> this.window.hide());

        this.minimizeIcon.setImage(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/fr/clipquest/assets/images/minimize.png"))));
        this.minimizeIcon.setOnMouseClicked(event -> this.window.setIconified(true));

        if (this.session.getCurrentView().equals("HOME")) {
            this.settingsIcon.setVisible(true);
            this.settingsIcon.setImage(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/fr/clipquest/assets/images/settings.png"))));
            this.settingsIcon.setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY) {
                    this.window.show("SettingsView");
                } else if (event.getButton() == MouseButton.SECONDARY) {
                    System.out.println("right click");
                }
            });
        } else if (this.session.getCurrentView().equals("SETTINGS")) {
            this.homeIcon.setVisible(true);
            this.homeIcon.setImage(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/fr/clipquest/assets/images/home.png"))));
            this.homeIcon.setOnMouseClicked(event -> {
                this.window.show("HomeView");
            });
        }
    }

}
