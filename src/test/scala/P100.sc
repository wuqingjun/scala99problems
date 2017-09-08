// Binary Tree

class Tree[+T]

case object Empty extends Tree[Nothing]
case class Node[T](val elem: T, val left: Tree[T], val right: Tree[T]) extends Tree[T]

def inOrder[T](t: Tree[T]): List[T] = t match {
  case Empty => Nil
  case Node(e, left, right) => inOrder(left) ::: List(e) ::: inOrder(right)
}

inOrder( Node(1, Node(2, Node(3, Empty, Empty), Node(4, Empty, Empty)), Node(5, Empty, Empty) ) )

def preOrder[T](t: Tree[T]) : List[T] = t match{
  case Empty => Nil
  case Node(e, left, right) => e :: preOrder(left) ::: preOrder(right)
}
preOrder( Node(1, Node(2, Node(3, Empty, Empty), Node(4, Empty, Empty)), Node(5, Empty, Empty) ) )


def postOrder[T](t: Tree[T]) : List[T] = t match{
  case Empty => Nil
  case Node(e, left, right) => postOrder(left) ::: postOrder(right) ::: List(e)
}

postOrder( Node(1, Node(2, Node(3, Empty, Empty), Node(4, Empty, Empty)), Node(5, Empty, Empty) ) )

def size[T](t: Tree[T]): Int = t match{
  case Empty => 0
  case Node(e, left, right) => 1 + size(left) + size(right)
}

size( Node(1, Node(2, Node(3, Empty, Empty), Node(4, Empty, Empty)), Node(5, Empty, Empty) ) )


def leafCount[T](t: Tree[T]): Int = t match{
  case Empty => 0
  case Node(e, Empty, Empty) => 1
  case Node(e, left, right) => leafCount(left) + leafCount(right)
}

leafCount( Node(1, Node(2, Node(3, Empty, Empty), Node(4, Empty, Empty)), Node(5, Empty, Empty) ) )

def leaves[T](t: Tree[T]) : List[T] = t match {
  case Empty => Nil
  case Node(e, Empty, Empty) => List(e)
  case Node(e, left, right) => leaves(left) ::: leaves(right)
}

leaves( Node(1, Node(2, Node(3, Empty, Empty), Node(4, Empty, Empty)), Node(5, Empty, Empty) ) )


def height[T](t: Tree[T]) : Int = t match{
  case Empty => 0
  case Node(e, l, r) => 1 + math.max(height(l), height(r))
}

height( Node(1, Node(2, Node(3, Empty, Empty), Node(4, Empty, Empty)), Node(5, Empty, Empty) ) )
