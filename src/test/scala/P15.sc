def duplicateN[A](n: Int, ls: List[A]) : List[A] = ls flatMap (List.fill(n)(_))

duplicateN(3, List('a, 'b, 'c, 'c, 'd))