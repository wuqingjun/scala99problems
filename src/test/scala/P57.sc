sealed abstract class Tree[+T] {
  def addValue[U >: T <% Ordered[U]](x: U): Tree[U]
}

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  def addValue[U >: T <% Ordered[U]](x: U): Tree[U] = {
    if (x < value) Node(value, left.addValue(x), right)
    else Node(value, left, right.addValue(x))
  }
}

case object End extends Tree[Nothing] {
  def addValue[U <% Ordered[U]](x: U): Tree[U] = Node(x, End, End)
}

object Tree{
  def fromList[T <% Ordered[T]](l: List[T]) : Tree[T] = l.foldLeft(End: Tree[T])((r, e) => r.addValue(e))
}

Tree.fromList(List('a, 'b, 'c, 'd, 'e, 'f, 'g))

