def encode[A](ls: List[A]) : List[(Int, A)] = {
 ls.foldLeft(List[(Int, A)]())((B, A) => if(B.isEmpty || B.last._2 != A) B ++ List((1, A)) else B.init ++ List((B.last._1 + 1, B.last._2 )) )
}

encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))