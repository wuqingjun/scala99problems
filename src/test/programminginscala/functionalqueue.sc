class Queue[T] private(private val leading: List[T], private val trailing: List[T]) {
  private def mirror  = if(leading.isEmpty) new Queue(trailing.reverse, Nil) else this
  def head = mirror.leading.head
  def tail = {
    val q = mirror
    new Queue(q.leading.tail, q.trailing)
  }
  def append[T](x: T) = new Queue(leading, x :: trailing)
}

object Queue{
  def apply[T](xs: T*) = new Queue[T](xs.toList, Nil)
}


val q1 = Queue(List[Int](1, 2, 3), List[Int]())
val q2 = q1.append(4)
val q3 = q2.append(5)
println(q3.head)
val q4 = q3.tail
println(q4.head)
val q5 = q4.tail
println(q5.head)


