trait Printable{
  def print(): Unit = {
    println(this)
  }
}

class Frog extends Object with Printable{
  override def toString = "a frog"
}

val frog = new Frog
frog.toString

frog.print()

val pr: Printable = frog

pr.print()


trait HashCaching {
  private var cachedHash: Int = 0
  private var hashComputed: Boolean = false

  def computeHash: Int
  override def hashCode = {
    if(!hashComputed){
      cachedHash = super.hashCode
      hashComputed = true
      println("cached...")
    }
    cachedHash
  }
}

abstract class BaseBook(val author: String, val title: String)
{
  override def hashCode = {
    Thread.sleep(1000)
    println("sleeping")
    author.hashCode + title.hashCode
  }
}


trait HashScrambling
{
  override def hashCode = {
    val original = super.hashCode
    def rl(i: Int) = Integer.rotateLeft(original, i)
    println("scrambling...")
    original ^ rl(8) ^ rl(24)
  }
}

class Book(author: String, title: String) extends BaseBook(author, title) with Ordered[Book]
with HashScrambling
with HashCaching
{
  override def compare(that: Book): Int = if(author < that.author) -1
  else if(author > that.author) 1
  else if(title < that.title) -1
  else if(title > that.title) 1
  else 0

  override def equals(that: scala.Any): Boolean = that match {
    case that: Book => compare(that) == 0
    case _ => false
  }

  def computeHash = author.hashCode + title.hashCode
}


val b = new Book("aaa", "bbb")
b.hashCode