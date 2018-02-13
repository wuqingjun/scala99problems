sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

def describe(e: Expr): String = (e: @unchecked) match{
  case Number(x) => "a Number"
  case Var(_) => "a Variable"
}

val v = Var("x")
val op = BinOp("+", Number(1), v)
v.name
op.left
op.right
println(op)


def simplifyTop(expr: Expr): Expr = expr match {
  case UnOp("-", UnOp("-", e)) => e
  case BinOp("+", e, Number(0)) => e
  case BinOp("*", e, Number(1)) => e
  case _ => expr
}

simplifyTop(UnOp("-", UnOp("-", Var("x"))))
simplifyTop(BinOp("*", Number(2), Number(1)))

BinOp("+", Number(1), Number(2)) match {
  case BinOp(_, _, _) => println("binary operation")
  case _ => println("something else")
}

def describe(x: Any) = x match {
  case 5 => "five"
  case true => "truth"
  case "hello" => "hi!"
  case Nil => "the empty list"
  case _ => "something else"
}

describe(3)
describe(5)
describe(false)
describe(true)
describe(Nil)

import Math._
val pi = Math.PI
E match {
  case pi => "strange math? Pi = " + pi
  case _ => "OK"
}

List(0, 1, 2, 3) match {
  case List(0, _, _*) => println("found it")
  case _ => println("not found it")
}

("hello", 10, true) match {
  case (word, index, bool) => println("what I got is " + word + index.toString + bool.toString)
}


def generalSize(x: Any) : Int = x match {
  case s: String => s.length
  case m: Map[_, _] => m.size
  case _ => -1
}

generalSize("abc")
generalSize(Map(1 -> 'a', 2 -> 'b'))
generalSize(Math.PI)

def isIntIntMap(x: Any) : Boolean = x match{
  case m: Map[Int, Int] => true
  case _ => false
}

isIntIntMap(Map("abc" -> "abc"))

def isStringArray(x: Any) = x match{
  case a: Array[String] => "yes"
  case x: AnyRef => "No"
}

isStringArray(Array("abc"))

isStringArray(Array(1, 2, 3))

UnOp("abs", UnOp("abs", Number(5))) match {
  case UnOp("abs", e@UnOp("abs", _)) => println(e.operator)
  case _ => println("something else")
}

def simplifyAdd(e: Expr) = e match{
  case BinOp("+", x, y) if(x == y) => BinOp("*", x, Number(2))
  case _ => e
}

simplifyAdd(BinOp("+", Number(3), Number(3)))
0

def guard(x: Any): Unit = x match{
  case n: Int if n > 0 => println("Positive")
  case s: String if s.length > 0 && s(0) == 'a' => println("a**")
  case _ => println("something else")
}

guard(3)
guard(-3)
guard("apple")

