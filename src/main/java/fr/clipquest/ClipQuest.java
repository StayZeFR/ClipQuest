package fr.clipquest;

import fr.clipquest.controllers.HomeController;
import javafx.application.Application;
import javafx.stage.Stage;

public class ClipQuest extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Window window = new Window();
        window.show(new HomeController());
    }

    public static void main(String[] args) {
        launch();
    }
}
