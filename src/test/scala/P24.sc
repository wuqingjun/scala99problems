def lotto(n: Int, M: Int) : List[Int] = {
  val r = util.Random

  def itr(result: List[Int], m: Int) : List[Int] = m <= 0 match {
    case true => result
    case false => {
      val cand = r.nextInt(M + 1)
      if(result.contains(cand)) itr(result, m)
      else itr(cand :: result, m - 1)
    }
  }

  itr(Nil, n)
}

lotto(6, 49)
