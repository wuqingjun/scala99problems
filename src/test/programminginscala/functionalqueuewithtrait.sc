trait Queue[T]{
  def head: T
  def tail: Queue[T]
  def append: Queue[T]
}

object Queue{
  def apply[T](xs: T*): Queue[T] = new QueueImp(xs.toList, Nil)

  private class QueueImp(leading: List[T], trailing: List[T]) extends Queue
}