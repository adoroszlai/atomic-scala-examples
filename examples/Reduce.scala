// Reduce.scala
import com.atomicscala.AtomicTest._

val v = Vector(1, 10, 100, 1000)
v.reduce((sum, n) => sum + n) is 1111

var result = 0
for (i <- v) {
  result += i
}
result is 1111

def sumIt(args:Int*):Int =
  args.reduce((sum, n) => sum + n)

sumIt(1, 2, 3) is 6
sumIt(45, 45, 45, 60) is 195
