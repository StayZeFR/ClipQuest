package fr.clipquest;

import fr.clipquest.models.Database;
import fr.clipquest.models.dao.UserDAO;
import fr.clipquest.models.entities.UserEntity;
import fr.clipquest.utils.ConfigManager;
import fr.clipquest.utils.session.Session;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ClipQuest extends Application {

    public static Session session;

    @Override
    public void start(Stage stage) throws Exception {
        new ConfigManager(Config.CONFIG_PATH.getValue() + Config.CONFIG_FILE.getValue());
        UserDAO userDAO = new UserDAO();

        Window window = new Window(Config.NAME.getValue());
        window.setMain();
        window.initStyle(StageStyle.UNDECORATED);
        window.setResizable(false);
        // window.setMinimizeIcon("login.png");
        if (ConfigManager.getInstance().getProperty("token").isEmpty() || userDAO.get("token", ConfigManager.getInstance().getProperty("token")).isEmpty()) {
            if (ConfigManager.getInstance().getProperty("username").isEmpty()) {
                window.show("RegisterView");
            } else {
                window.show("LoginView");
            }
        } else {
            window.show("HomeView");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
