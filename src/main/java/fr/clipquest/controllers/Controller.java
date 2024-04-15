package fr.clipquest.controllers;

import fr.clipquest.Window;
import fr.clipquest.utils.Parameters;

public abstract class Controller {

    protected Parameters parameters;
    protected Window window;

    protected Controller() {
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
