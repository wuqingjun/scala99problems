
def randomSelect[A](n: Int, ls: List[A]) : List[A] = {
  val r = util.Random

  def itr(m: Int, result: List[A], l: List[A]): List[A] = m match {
    case 0 => result
    case _ => {
      val i = r.nextInt(ls.length)
      val (p1, p2) = ls.splitAt(i)
      itr(m - 1, p2.head :: result, p1 ::: (if (p2.length > 0)  p2.drop(1) else Nil) ) }
  }

  itr(n, Nil, ls)
}

randomSelect(2, List('a, 'b, 'c, 'd, 'e))


