object Element {
  def elem(contents: Array[String]): Element = new ArrayElement(contents)
  def elem(chr: Char, width: Int, height: Int) : Element = new UniformElement(chr, width, height)
  def elem(line: String) : Element = new LineElement(line)
}

abstract class Element {
  def contents: Array[String]
  def width: Int = contents(0).length
  def height: Int = contents.length

  def above(that: Element) : Element = {
    val this1 = this widen that.width
    val that1 = that widen this1.width
    //    print("11111" + this1.contents.mkString)
    //    println("22222" + that1.contents.mkString)
    new ArrayElement(this1.contents ++ that1.contents)
  }

  def beside(that: Element) : Element = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    Element.elem( for((line1, line2) <- this1.contents zip that1.contents)
      yield line1 + line2)
  }

  override def toString = contents mkString "\n"

  private def spaces(n: Int) = Array.fill(n)(' ').mkString

  private def widen(w: Int) : Element = if(w <= width) this
  else {
    val lpad = (w - width) / 2
    val rpad = w - (lpad + width)
    new ArrayElement(
      for(line <- contents)
        yield spaces(lpad) + line + spaces(rpad)
    )
  }

  private def heighten(h: Int): Element = if(h <= height) this
  else{
    val top = Element.elem(' ', width, (h - height) / 2)
    var bot = Element.elem(' ', width, h - height - top.height)
    top above this above bot
  }

}


class ArrayElement(override val contents: Array[String]) extends Element{
}

class LineElement(s: String) extends Element {
  def contents = Array(s)
  override def width = s.length
  override def height = 1
}

class UniformElement(ch: Char, override val width: Int, override val height: Int) extends Element{
  private val line = Array.fill(width)(ch).mkString

  override def contents: Array[String] = Array.fill(height)(line)
}

class LineElement2(s: String) extends ArrayElement(Array(s)) {
  override def width = s.length
  override def height = 1
}

sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr


val opGroups = Array(Set("|", "||"), Set("&", "&&"), Set("^"), Set("==", "!="), Set("<", "<=", ">", ">="), Set("+", "-"), Set("*", "%"))
val precedence = {
  val assocs = for{i <- 0 until opGroups.length
    op <- opGroups(i)
  } yield op -> i
  Map() ++ assocs
}

val unaryPrecedence = opGroups.length
val fractionPrecedence = -1

//def format(e: Expr, enclPrec: Int) : Element = e match{

 // case Var()
//}