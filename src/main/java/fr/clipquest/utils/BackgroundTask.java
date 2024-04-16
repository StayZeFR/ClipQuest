package fr.clipquest.utils;

import javafx.concurrent.Task;

import java.awt.*;
import java.awt.event.KeyEvent;

public class BackgroundTask extends Task<Void> {

    private static BackgroundTask instance;

    private BackgroundTask() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(e -> {
            System.out.println("OKKKKK");
            if (e.getID() == KeyEvent.KEY_TYPED) {
                System.out.println("Touche appuyée : " + e.getKeyChar());
            }
            return false;
        });
    }

    @Override
    protected Void call() throws Exception {
        while (true) {
            Thread.sleep(1000);
        }
    }

    public static BackgroundTask getInstance() {
        if (instance == null) {
            instance = new BackgroundTask();
        }
        return instance;
    }
}
