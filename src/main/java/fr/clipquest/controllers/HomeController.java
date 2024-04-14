package fr.clipquest.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Objects;

public class HomeController extends Controller {
    @Override
    public void init() {
        this.render("HomeView");
    }
}
