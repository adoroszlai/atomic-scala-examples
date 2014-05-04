import com.atomicscala.AtomicTest._

case class Dimension(height:Int = 10, var width:Int = 10)

val c = new Dimension(width=12)
c.height is 10
c.width is 12
