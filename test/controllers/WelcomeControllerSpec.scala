package controllers

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.test.FakeRequest
import play.api.test.Helpers.{status, _}

class WelcomeControllerSpec extends PlaySpec with GuiceOneAppPerTest{
    "Welcome Controller GET" should {
      "return a successfull response" in {
        val controller = new WelcomeController
        val result = controller.welcome.apply(FakeRequest())
        status(result) mustBe OK
      }
    }
}
