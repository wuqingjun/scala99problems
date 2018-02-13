import java.io.{File, PrintWriter}

var increase = (x: Int) => x + 2

increase(3)

increase = (x: Int) => {
  println("Line 1")
  x + 30}

increase(23)


val someNumbers = List(-11, -10, -5, 0, 5, 10)
someNumbers.filter(_ > 2 )

val f = (_: Int) + (_: Int)
f(5, 10)


someNumbers.foreach(println)


def echo(args: String*) = for(arg <- args) println(arg)

echo()

echo("One")

echo("hello", "world")

echo("1", "2", "3", "4")

val arr = Array("What's", "up", "doc?")

echo(arr: _*)



def twice(op: Double => Double, x: Double) = op(op(x))

twice(_ + 1, 5)


def withPrintWriter(file: File, op: PrintWriter => Unit): Unit ={
  val writer = new PrintWriter(file)
  try{
    op(writer)
  }finally {
    writer.close()
  }
}

//withPrintWriter(new File("tmp.txt"), writer => writer.println(new java.util.Date))


println{"Hello, World!"}