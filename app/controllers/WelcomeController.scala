package controllers

import play.api.mvc.Action
import play.api.mvc.Controller

class WelcomeController extends Controller{
    def welcome() = Action {
      Ok(views.html.welcome())
    }
}
