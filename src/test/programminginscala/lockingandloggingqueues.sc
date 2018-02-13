import scala.collection.mutable.ArrayBuffer

trait Queue{
  def get(): Int
  def put(x: Int)
}

trait LockingQueue extends Queue{
  abstract override def get() : Int = synchronized {super.get()}

  abstract override def put(x: Int) = synchronized {super.put(x)}
}

trait LoggingQueue extends Queue{
  def log(message: String) = println(message)
  abstract override def get(): Int = {
    val x = super.get()
    log("got: " + x)
    x
  }
  abstract override def put(x: Int): Unit = {
    super.put(x)
    log("put: " + x)
  }
}

class StandardQueue extends Queue{
  private val buf = new ArrayBuffer[Int]

  def get = {println("Standard get: "); buf.remove(0);}
  def put(x: Int) = {println("Standard put: "); buf += x;}
}

val q1 = new StandardQueue with LockingQueue with LoggingQueue
val q2 = new StandardQueue with LoggingQueue

q1.put(1)
q1.put(2)
q1.get()
