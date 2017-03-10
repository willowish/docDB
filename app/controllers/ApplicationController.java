package controllers;

import play.mvc.*;

import views.html.*;

public class ApplicationController extends Controller {

    public Result login() {
        return ok(login.render("Hello"));
    }

    public Result index() {
        return ok(index.render("Your new application is dead."));
    }

}
