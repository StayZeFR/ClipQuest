package fr.clipquest.controllers;

import fr.clipquest.Window;
import javafx.scene.Scene;

public abstract class Controller {

    protected Window window;
    protected Scene scene;

    public void setWindow(Window window) {
        this.window = window;
    }

    public abstract void view();

}