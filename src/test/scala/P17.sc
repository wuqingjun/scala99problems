def split[A](n: Int, l: List[A]) : Tuple2[List[A], List[A]]  = {
  (l.take(n), l.drop(n))
}

split(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g'))

def splitBuiltIn[A](n: Int, l: List[A]) = {
  l.splitAt(n)
}

splitBuiltIn(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g'))

