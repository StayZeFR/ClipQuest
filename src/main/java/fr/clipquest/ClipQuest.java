package fr.clipquest;

import fr.clipquest.controllers.HomeController;
import fr.clipquest.utils.Session;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ClipQuest extends Application {

    public static Session session;

    @Override
    public void start(Stage stage) throws Exception {
        Window window = new Window();
        window.setMain();
        window.initStyle(StageStyle.UNDECORATED);
        window.setResizable(false);
        window.setMinimizeIcon("login.png");
        window.show("HomeView");
    }

    public static void main(String[] args) {
        launch();
    }
}
