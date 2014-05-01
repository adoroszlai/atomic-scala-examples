// Temperature.scala
import com.atomicscala.AtomicTest._

class Temperature {
  var current = 0.0
  var scale = "f"
  def setFahrenheit(now:Double):Unit = {
    current = now
    scale = "f"
  }
  def setCelsius(now:Double):Unit = {
    current = now
    scale = "c"
  }
  def setKelvin(now:Double):Unit = {
    current = now
    scale = "k"
  }
  def getFahrenheit():Double = {
    if(scale == "f")
      current
    else
      getCelsius() * 9.0/5.0 + 32.0
  }
  def getCelsius():Double = {
    if(scale == "c")
      current
    else if (scale == "k")
      current - 273.15
    else
      (current - 32.0) * 5.0/9.0
  }
  def getKelvin():Double = {
    if (scale == "k")
      current
    else
      getCelsius() + 273.15
  }
}

val temp = new Temperature
temp.setFahrenheit(98.6)
temp.getFahrenheit() is 98.6
temp.getCelsius is 37.0
temp.getKelvin is 310.15
temp.setCelsius(100.0)
temp.getCelsius is 100.0
temp.getFahrenheit is 212.0
temp.getKelvin is 373.15
temp.setKelvin(0)
temp.getKelvin is 0.0
temp.getCelsius is -273.15
Math.round(temp.getFahrenheit) is -460
