trait Abstract{
  type T
  def transform(x: T): T
  val initial: T
  var current: T
}

class Concrete extends Abstract{
  type T = String
  def transform(x: T) = x + x
  val initial = "hi"
  var current = initial
}


abstract class  A{
  val v: String
  def m: String
}

abstract class C1 extends A{
  val v: String
  val m: String
}

abstract class C2 extends A{
  val v: String
  def m: String
}
