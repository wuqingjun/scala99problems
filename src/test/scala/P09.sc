def pack[A](ls: List[A]): List[List[A]] = ls match {
  case x :: xs => (x :: xs.takeWhile( _ == x)) :: pack(xs.dropWhile(_ == x))
  case Nil => Nil
}

pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))


def packTail[A](ls: List[A]) : List[List[A]] = {
  def iter(result : List[List[A]], ls: List[A]) : List[List[A]] = ls match{
    case Nil => result
    case x :: tail => iter( result ++ List((x :: tail.takeWhile( _ == x))),  tail.dropWhile(_ == x))
  }
  iter(List[List[A]](), ls)
}

packTail(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))


def packSpan[A](ls: List[A]): List[List[A]] = ls match{
  case Nil => Nil
  case h :: tail => {
    val t = ls span (_ == h)
    t._1 :: packSpan(t._2)
  }
}


packSpan(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))


def packSpanTail[A](ls: List[A]): List[List[A]] = {
  def iter(result: List[List[A]], ls: List[A]) : List[List[A]] = ls match{
    case Nil => result
    case h :: tail => {
      val t = ls span(_ == h)
      iter(result ++ List(t._1), t._2)
    }
  }
  iter(List[List[A]](), ls)
}


packSpanTail(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
