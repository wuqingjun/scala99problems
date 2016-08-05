def dropR[A](n: Int, ls: List[A]) : List[A] = (n, ls) match {
  case (_, Nil) => Nil
    case(1, tail) => dropR(n, tail)
  case (_, h::tail) => h :: dropR(n - 1, tail)
}

dropR(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))