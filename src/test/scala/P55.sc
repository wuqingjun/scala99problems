sealed abstract class Tree[+T]

case class Node[+T](value: T, var left : Tree[T], var right: Tree[T]) extends Tree[T] {
  override def toString: String = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"
}

case object End extends Tree[Nothing] {
  override def toString: String = "."
}

object Node{
  def apply[T](value: T): Node[T] = Node(value, End, End)
}

def insert[T](root: Tree[T], value: T) : Tree[T]= root match {
  case End => Node(value)
  case Node => {
  if(root == None) Node(value)
  else if (root.value.toString > value.toString) root.left = insert(root.left, value) }
}

def buildTree[T](ls: List[T]) : Tree[T] = {
}

