package fr.clipquest;

import fr.clipquest.controllers.Controller;
import fr.clipquest.utils.SystemTrayUtil;
import fr.clipquest.utils.WindowDragger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Window extends Stage {

    private static Window main;

    public Window() {
        this("ClipQuest");
    }

    public Window(String title) {
        super();
        this.setTitle(title);
    }

    public void show(String view) {
        this.render(view);
    }

    public void setMain() {
        main = this;
    }

    public void setMinimizeIcon(String icon) {
        SystemTrayUtil.initSystemTray(this.getTitle(), icon);
    }

    private void render(String view) {
        String path = "/fr/clipquest/views/" + view + ".fxml";
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource(path));
            Parent root = loader.load();
            Controller controller = loader.getController();
            controller.setWindow(this);
            this.setScene(new Scene(root));
            WindowDragger.addDragListeners(this.getScene(), this);
            this.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Window getMain() {
        return main;
    }

}
