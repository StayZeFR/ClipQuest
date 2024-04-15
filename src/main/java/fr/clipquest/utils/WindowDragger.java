package fr.clipquest.utils;

import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class WindowDragger {

    private static double xOffset = 0;
    private static double yOffset = 0;

    public static void addDragListeners(Scene scene, Stage stage) {
        scene.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        scene.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
    }

    public static void removeDragListeners(Scene scene) {
        scene.setOnMousePressed(null);
        scene.setOnMouseDragged(null);
    }

}
