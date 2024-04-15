package fr.clipquest.controllers;

public class RegisterController extends Controller {

    public RegisterController() {
        super("RegisterView");
    }

    @Override
    public void init() {
    }

    @Override
    protected Controller getInstance() {
        return this;
    }
}
