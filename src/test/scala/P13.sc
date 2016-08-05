def encodeDirect[A](ls: List[A]) : List[(Int, A)] = ls match{
  case Nil => Nil
  case _ =>
    val t = ls span (_ == ls.head)
    (t._1.length, t._1.head) :: encodeDirect(t._2)
}

encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))


def encodeDirectTail[A](ls: List[A]) : List[(Int, A)] = {
  def iter(result: List[(Int, A)], ls: List[A]) : List[(Int, A)] = ls match{
    case Nil => result
    case _ => val t = ls span(_ == ls.head)
      iter (result ++ List(( t._1.length, t._1.head)), t._2)
  }
  iter(List[(Int, A)](), ls)
}

encodeDirectTail(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
