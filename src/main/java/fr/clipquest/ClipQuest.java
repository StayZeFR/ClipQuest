package fr.clipquest;

import fr.clipquest.models.dao.TokenDAO;
import fr.clipquest.utils.ConfigManager;
import fr.clipquest.utils.session.Session;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ClipQuest extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Platform.setImplicitExit(false);
        new ConfigManager(Config.CONFIG_PATH.getValue() + Config.CONFIG_FILE.getValue());
        Session session = new Session();

        Window window = new Window(Config.NAME.getValue());
        window.setMain();
        window.initStyle(StageStyle.UNDECORATED);
        window.setResizable(false);
        window.setMinimizeIcon("login.png");
        if (!session.isLogged()) {
            window.show("LoginView");
        } else {
            window.show("HomeView");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
