
def lengthRecursive[A](ls : List[A]) : Int = ls match
{
  case Nil => 0
  case _ :: tail => 1 + lengthRecursive(tail)
}


def lengthTailRecursive[A](result: Int, ls: List[A]): Int = ls match {
  case Nil => result
  case _ :: tail => lengthTailRecursive(1 + result, ls)
}


val a = lengthTailRecursive(0, List(0, 1, 2, 3, 4))