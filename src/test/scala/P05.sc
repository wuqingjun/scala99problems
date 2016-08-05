def reverseBuiltin[A](ls: List[A]): List[A] = ls.reverse

def reverseRecursive[A](ls: List[A]): List[A] = ls match{
  case Nil => Nil
  case h :: tail => reverseRecursive(tail) ++ List(h)
}

reverseRecursive(List(0, 1, 2, 3))

def reverseTailRecursive[A](ls: List[A]) : List[A] =
{
  def iter(result: List[A], currList: List[A]) : List[A] = currList match {
    case Nil => result
    case h :: tail => iter(result ++ List(h),  tail)
  }

  iter(Nil, ls)
}

def reverseFunctional[A](ls: List[A]) : List[A] = {
  ls.foldLeft(List[A]()){(B, A) => A :: B}
}


reverseFunctional(List(0, 1, 2, 3, 4))


def reverseFunctional2[A](ls: List[A]) : List[A] = {
  ls.foldRight(List[A]())((A, B) => B ++ List(A))
}

reverseFunctional2(List(0, 1, 2, 3))
