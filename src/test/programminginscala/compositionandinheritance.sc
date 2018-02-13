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


val tmp = ( new ArrayElement(Array("hello")) above
new ArrayElement(Array("world!")))

tmp.contents.length
print(tmp.contents(0))
print(tmp.contents(1))

object Spiral{
  val space = Element.elem(" ")
  val corner = Element.elem("+")

  def spiral(nedges: Int, direction: Int): Element = {
    if(nedges == 1) Element.elem("+")
    else {
      val sp = spiral(nedges - 1, (direction + 3) % 4)
      def verticalBar = Element.elem('|', 1, sp.height)
      def horizontalBar = Element.elem('-', sp.height, 1)
      if(direction == 0) (corner beside horizontalBar) above (sp beside space)
      else if(direction == 1) (sp above space) beside (corner above verticalBar)
      else if(direction == 2) (space beside sp) above (horizontalBar beside corner)
      else (verticalBar above corner) beside (space above sp)
    }
  }
}

println(Spiral.spiral(17, 0))

