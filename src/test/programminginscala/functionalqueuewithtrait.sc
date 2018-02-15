trait Queue[T]{
  def head: T
  def tail: Queue[T]
  def append: Queue[T]
}

object Queue{
  def apply[T](xs: T*): Queue[T] = new QueueImp(xs.toList, Nil)

  private class QueueImp(leading: List[T], trailing: List[T]) extends Queue{
    def normalize = if(leading.isEmpty) new  QueueImp(trailing.reverse, Nil) else this
    def head: T = normalize.leading.head
    def tail: QueueImp[T] =  {
      val q = normalize
      new QueueImp(leading.tail, q.trailing)
    }
    def append: T = new QueueImp(leading, x :: trailing)
  }
}

