
def compressRecursive[A](ls : List[A]): List[A] = ls match {
  case Nil => Nil
  case h :: tail => h :: compressRecursive(ls.dropWhile( _ == h))
}

compressRecursive(List('a', 'a', 'b', 'c', 'c', 'c', 'd'))


def compressTailREcursive[A](ls: List[A]) : List[A] = {
  def iter(result: List[A], currList: List[A]) : List[A] = currList match {
    case h :: tail => iter(result ++ List(h), currList.dropWhile(_ == h))
    case Nil => result
  }
  iter(List[A](), ls)
}

compressRecursive(List('a', 'a', 'b', 'c', 'c', 'c', 'd'))


def compressFunctionalRight[A](ls: List[A]) : List[A] = {
  ls.foldRight(List[A]())((A, B) => if(B.isEmpty || B.head != A) A :: B else B)
}

compressFunctionalRight(List('a', 'a', 'b', 'c', 'c', 'c', 'c', 'd'))


def compressFunctionalLeft[A](ls : List[A]) : List[A] = {
  ls.foldLeft(List[A]())((B, A) => if(B.isEmpty || A != B.last) B ++ List(A) else B)
}

compressFunctionalLeft(List('a', 'a', 'b', 'c', 'c', 'c', 'c', 'd'))
