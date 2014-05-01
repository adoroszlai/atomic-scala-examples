import com.atomicscala.AtomicTest._

class SimpleTime(h:Int, m:Int) {
  def hours:Int = h
  def minutes:Int = m
  def value:Int = h * 60 + m

  override def toString = {
    val m = Math.abs(minutes)
    val s = if (hours >= 0 && minutes < 0) "-" else ""
    f"$s$hours:$m%02d"
  }

  def -(other:SimpleTime) = {
    val diff = value - other.value
    new SimpleTime(diff / 60, diff % 60)
  }
}

val t1 = new SimpleTime(9, 30)
val t2 = new SimpleTime(9, 45)
val t3 = new SimpleTime(10, 15)
val t4 = new SimpleTime(10, 45)

t2 - t1 is "0:15"
t1 - t2 is "-0:15"
t3 - t1 is "0:45"
t1 - t3 is "-0:45"
t4 - t1 is "1:15"
t1 - t4 is "-1:15"
t3 - t2 is "0:30"
t2 - t3 is "-0:30"
t4 - t2 is "1:00"
t2 - t4 is "-1:00"
t4 - t3 is "0:30"
t3 - t4 is "-0:30"

