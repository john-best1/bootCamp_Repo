package controllers

import com.google.inject.Inject
import play.api.mvc.Action
import play.api.mvc.Controller
import services.GreetingService

class WelcomeController @Inject()(greeter: GreetingService)extends Controller{
    def welcome() = Action {
      val greeting = greeter.greeting
      Ok(views.html.welcome(greeting))
    }
}
