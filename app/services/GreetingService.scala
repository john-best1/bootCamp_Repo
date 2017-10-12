package services

import java.util.Calendar

import com.google.inject.ImplementedBy

class RealGreetingService extends GreetingService{
  def greeting: String = {
    val now = Calendar.getInstance()
    val hour = now.get(Calendar.HOUR_OF_DAY)
    if (hour < 12)
      "Good morning!"
    else
      "Good afternoon!"
}
}

@ImplementedBy(classOf[RealGreetingService])
trait GreetingService{
  def greeting : String
}

