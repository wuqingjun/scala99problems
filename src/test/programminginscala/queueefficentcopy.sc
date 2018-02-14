
class Queue[+T] (
                          private[this] var leading: List[T],
                          private[this] var trailing: List[T]
                        ){
  private def mirror() = if(leading.isEmpty) while(!trailing.isEmpty) {
    leading = trailing.head :: leading
    trailing = trailing.tail
  }

  def head: T = {
    mirror()
    leading.head
  }

  def tail: Queue[T] = {
    mirror()
    new Queue(leading.tail, trailing)
  }

  def append[U >: T](x: U) = new Queue(leading, x :: trailing)
}

//object Queue{
//  def apply[T](xs: T*) = new Queue[T](xs.toList, Nil)
//}

val q1 = new Queue(List(1, 2, 3), Nil)
val q2 = q1.append(4)
val q3 = q2.append(5.0)
println(q3.head)
val q4 = q3.tail
println(q4.head)
val q5 = q4.tail
println(q5.head)
val q6 = q5.tail
println(q6.head)
val q7 = q6.append("shit")
