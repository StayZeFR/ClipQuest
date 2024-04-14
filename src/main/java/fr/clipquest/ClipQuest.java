package fr.clipquest;

import fr.clipquest.controllers.HomeController;
import fr.clipquest.controllers.LoginController;
import fr.clipquest.controllers.RegisterController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClipQuest extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Window window = new Window();
        window.show(new RegisterController());
        /*Parent root = FXMLLoader.load(getClass().getResource("/fr/clipquest/views/HomeView.fxml"));
        stage.setTitle("FXML Example");
        stage.setScene(new Scene(root, 300, 200));
        stage.show();*/
    }

    public static void main(String[] args) {
        launch();
    }
}
