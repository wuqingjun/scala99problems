def rotate[A](n: Int, ls: List[A]): List[A] ={
  val nBounded = if(ls.isEmpty) 0 else n % ls.length
  if(nBounded < 0) rotate(n + ls.length, ls)
  else (ls drop nBounded) ::: (ls take nBounded)
}

rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))