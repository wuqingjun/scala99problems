def insertAt[A](a: A, n:Int, ls: List[A]) : List[A] = {
  (ls take n) ::: a :: (ls drop n)
}

insertAt('e, 1, List('a, 'b, 'c, 'd))

def insertAt2[A](e: A, n: Int, ls: List[A]): List[A] = ls.splitAt(n) match{
  case (pre, post) => pre ::: e :: post
}


insertAt2('e, 1, List('a, 'b, 'c, 'd))
