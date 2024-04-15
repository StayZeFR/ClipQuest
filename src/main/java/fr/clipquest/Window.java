package fr.clipquest;

import fr.clipquest.controllers.Controller;
import javafx.stage.Stage;

import java.lang.reflect.InvocationTargetException;

public class Window extends Stage {

    public Window() {
        this("ClipQuest");
    }

    public Window(String title) {
        super();
        this.setTitle(title);
    }

    public void show(Class<? extends Controller> clazz) {
        try {
            Controller controller = clazz.getDeclaredConstructor().newInstance();
            controller.initialize(this);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void show(Controller controller) {
        controller.initialize(this);
    }

}
