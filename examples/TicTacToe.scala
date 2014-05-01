// TicTacToe.scala
import com.atomicscala.AtomicTest._

val success = "successful move"
val invalid = "invalid move"
val draw = '-'
val empty = ' '
val not_yet = ""

class Cell {
  var entry = empty
  def set(e:Char):String = {
    if (entry == empty && (e=='X' || e=='O')) {
      entry = e
      success
    } else
      invalid
  }
	override def toString = entry.toString
}

class Grid {
  val cells = Vector(
    Vector(new Cell, new Cell, new Cell),
    Vector(new Cell, new Cell, new Cell),
    Vector(new Cell, new Cell, new Cell)
  )
	val winning_combinations = Vector(
		cells(0), cells(1), cells(2),
		Vector(cells(0)(0), cells(1)(0), cells(2)(0)),
		Vector(cells(0)(1), cells(1)(1), cells(2)(1)),
		Vector(cells(0)(2), cells(1)(2), cells(2)(2)),
		Vector(cells(0)(0), cells(1)(1), cells(2)(2)),
		Vector(cells(0)(2), cells(1)(1), cells(2)(0))
	)
	var gameOver = not_yet

  def play(e:Char, x:Int, y:Int):String = {
		if (gameOver != not_yet)
			gameOver + " already"
    else if (x < 0 || x > 2 || y < 0 || y > 2)
      invalid
    else {
      val moveResult = cells(x)(y).set(e)
			if (moveResult == invalid)
				moveResult
			else {
				if (isGameOver) gameOver
				else moveResult
			}
		}
  }

	def printBoard = {
		val row_sep = "-------"
		val cell_sep = "|"

		println(row_sep)
		for (line <- cells) {
			for (cell <- line)
				print(cell_sep + cell)
			println(cell_sep)
			println(row_sep)
		}
	}

	def rowResult(row:Vector[Cell]):Char = {
		val entries = row.map(x => x.entry)

		val x = entries.count(c => c == 'X')
		if (x == 3) return 'X'

		val o = entries.count(c => c == 'O')
		if (o == 3) 'O'
		else if (x > 0 && o > 0) draw
		else empty
	}

	def isGameOver:Boolean = {
		gameOver = checkGameResult
		gameOver != not_yet
	}
	def checkGameResult:String = {
		val results = winning_combinations.map(row => rowResult(row))
		if (results.contains('X')) "X won"
		else if (results.contains('O')) "O won"
		else if (!results.contains(empty)) "draw"
		else not_yet
	}
}

val grid = new Grid
grid.play('X', 1, 1) is success
grid.play('X', 1, 1) is invalid
grid.play('O', 1, 3) is invalid

val g1 = new Grid
g1.play('X', 1, 1) is success
g1.play('O', 0, 0) is success
g1.play('X', 2, 0) is success
g1.play('O', 0, 2) is success
g1.play('X', 0, 1) is success
g1.play('O', 2, 1) is success
g1.play('X', 1, 2) is success
g1.play('O', 1, 0) is "draw"
g1.printBoard

val g2 = new Grid
g2.play('X', 1, 1) is success
g2.play('X', 2, 0) is success
g2.play('X', 0, 2) is "X won"
g2.play('O', 1, 2) is "X won already"
g2.printBoard
