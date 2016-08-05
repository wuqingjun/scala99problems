def decode[A](ls: List[(Int, A)]): List[A] = ls.flatMap(e => List.fill(e._1)(e._2))

decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))


List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)).map(e => List.fill(e._1)(e._2))


def decodeR[A](ls: List[(Int, A)]) : List[A] = {
  def iter(result: List[A], ls: List[(Int, A)]) : List[A] = ls match {
    case Nil => result
    case e :: tail => iter(result ++ List.fill(e._1)(e._2), tail )
  }

  iter(List[A](), ls)
}

decodeR(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))


def decodeAnyR[T](ls: List[Any]) : List[T] = {
  def iter(result: List[T], ls: List[Any]): List[T] = ls match {
    case (a: Int, b: T) :: tail => iter(result ++ List.fill(a)(b), tail)
    case (b: T) :: tail => iter(result ++ List(b), tail)
    case Nil => result
  }
  iter(List[T](), ls)
}


decodeAnyR(List((4, 'a), 'b, (2, 'c), (2, 'a), 'd, (4, 'e)))

def decodeAny[T](ls: List[Any]) : List[T] =
  ls.foldLeft(List[T]())((B, A) => A match {
    case (a: Int, b: T) => B ++ List.fill(a)(b)
    case (b: T)  => B ++ List(b)
  })


decodeAny(List((4, 'a), 'b, (2, 'c), (2, 'a), 'd, (4, 'e)))

def decodeAnyRight[T](ls: List[Any]) : List[T] = ls.foldRight(List[T]())((A, B) => A match {
  case(a: Int, b: T) => List.fill(a)(b) ++ B
  case (b: T) => b :: B
})

decodeAnyRight(List((4, 'a), 'b, (2, 'c), (2, 'a), 'd, (4, 'e)))

