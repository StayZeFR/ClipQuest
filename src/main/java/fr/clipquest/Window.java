package fr.clipquest;

import fr.clipquest.controllers.Controller;
import javafx.stage.Stage;

public class Window extends Stage {

    public Window() {
        this("ClipQuest");
    }

    public Window(String title) {
        super();
        setTitle(title);
        this.show();
    }

    public void show(Controller controller) {
        controller.setWindow(this);
        controller.view();
    }

}
