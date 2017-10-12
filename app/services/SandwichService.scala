package services

import models.Sandwich
import com.google.inject.ImplementedBy
import uk.gov.hmrc.play.http.HeaderCarrier
import uk.gov.hmrc.play.http.ws.WSGet

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future



class RealSandwichService extends SandwichService {

  val http = new WSGet {
    override val hooks = NoneRequired
  }
  override def sandwiches(): Future[List[Sandwich]] = {
    implicit val hc = HeaderCarrier()
    http.GET[List[Sandwich]]("http://localhost:3000/sandwiches")
  }
}

class IntegrationSandwichService extends SandwichService{
  override def sandwiches(): Future[List[Sandwich]] = Future(List())
}

@ImplementedBy(classOf[RealSandwichService])
trait SandwichService {
  def sandwiches() : Future[List[Sandwich]]
}