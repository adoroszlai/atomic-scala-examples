// 1
val vi = Vector(8, 20, 10, 5)
val vc = Vector('d', 's', 'f', 'a')
val vs = Vector("Updater", "Software", "Terminal")
val svi = vi.sorted
val svc = vc.sorted
val svs = vs.sorted
vi.min
vc.min
vs.min
vi.max
vc.max
vs.max
var si = ""
for (v <- svi) si += v + " "
var sc = ""
for (v <- svc) sc += v + " "
var ss = ""
for (v <- svs) ss += v + " "
println(si, sc, ss)

// 2
val vv = Vector(vi, vc, vs)
var s = ""
for (v <- vv) {
	for (a <- v) {
		s += a + " "
	}
}
println(s)
