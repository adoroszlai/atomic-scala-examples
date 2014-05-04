// SimpleMap.scala
import com.atomicscala.AtomicTest._

val v = Vector(1, 2, 3, 4)
v.map(n => 11 * n + 10) is Vector(21, 32, 43, 54)

var v2:Vector[Int] = Vector()
for (i <- v) {
  v2 = v2 :+ (11 * i + 10)
}
v2 is Vector(21, 32, 43, 54)
