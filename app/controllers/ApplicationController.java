package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.drive;

public class ApplicationController extends Controller {

	public Result login() {
		return TODO;
	}

	public Result index() {
		return ok(drive.render(""));
	}

}
