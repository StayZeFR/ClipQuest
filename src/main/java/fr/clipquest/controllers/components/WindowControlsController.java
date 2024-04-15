package fr.clipquest.controllers.components;

import fr.clipquest.Window;
import fr.clipquest.controllers.Controller;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class WindowControlsController extends Controller {

    @FXML
    private ImageView closeIcon;
    @FXML
    private ImageView minimizeIcon;

    @FXML
    public void initialize() {
        this.closeIcon.setImage(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/fr/clipquest/assets/images/close.png"))));
        this.closeIcon.setOnMouseClicked(event -> {
            this.window.close();
        });

        this.minimizeIcon.setImage(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/fr/clipquest/assets/images/minimize.png"))));
        this.minimizeIcon.setOnMouseClicked(event -> {
            this.window.setIconified(true);
        });
    }
}