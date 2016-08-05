def dropRecursive[A](n: Int, ls: List[A]) = List[A] = {

def dropR[A](c: Int, ls: List[A]) : List[A] = (c, ls) match {
  case (_, Nil) => Nil
  case(1, _::tail) => dropR(n, tail)
  case (_, h::tail) => h :: dropR(c - 1, tail)
}
dropR(n, ls)
}

dropRecursive(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))



def dropFunctional[A](n: Int, ls: List[A]) : List[A] = {
  ls.zipWithIndex filter { v => v._2 % n != 0} map {_._1}
}