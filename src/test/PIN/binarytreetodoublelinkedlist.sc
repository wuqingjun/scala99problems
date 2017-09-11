import scala.collection.mutable

sealed trait Tree[+T] {
}

case object Empty extends Tree[Nothing]
case class Node[T](val elem: T, val left: Tree[T], val right: Tree[T]) extends Tree[T]

def treeToList(root: Tree[Int]) : collection.mutable.MutableList[Int] = {
  def itr(tail: collection.mutable.MutableList[Int], node: Tree[Int]) : Unit = node match {
    case Node(n, left, right) => {tail += n; itr(tail, left); itr(tail, right);}
    case Empty => {}
  }
  val ll = new mutable.MutableList[Int]
  itr(ll, root)
  ll
}

def morrisTreeToList[U](root: Tree[U]) : mutable.MutableList[U] = {
  var prev: Tree[U] = Empty
  var curr: Tree[U] = root
  while(curr != Empty){
    curr match{
      case Node(elem, Empty, right) => {
        println(elem)
        curr = Empty
      }
      case Node(elem, left, right) =>{
        prev = left
      }
    }
  }
  mutable.MutableList[U]()
}

treeToList( Node(1, Node(2, Node(3, Empty, Empty), Node(4, Empty, Empty)), Node(5, Empty, Empty) ) )
