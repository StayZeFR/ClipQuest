package fr.clipquest.controllers;

import fr.clipquest.Window;
import fr.clipquest.utils.Parameters;
import fr.clipquest.utils.session.Session;

public abstract class Controller {

    protected Session session;
    protected Parameters parameters;
    protected Window window;

    protected Controller() {
        this.session = Session.getInstance();
        if (!this.getClass().getPackageName().contains("components")) {
            this.session.setCurrentView(this.getClass().getSimpleName().replaceAll("Controller", "").toUpperCase());
        }
        this.parameters = new Parameters();
        this.window = Window.getMain();
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

}
