import scala.collection.mutable

def randomPermute[A](ls: List[A]) : List[A] = {
  val rand = util.Random
  def itr(result: List[A], l: List[A]) : List[A] = l match {
    case Nil => result
    case _ => {
      val i = rand.nextInt(l.length)
      val (p1, p2) = l.splitAt(i)
      itr(p2.head :: result, p1 ::: (if (p2.length > 0 ) p2.drop(1) else Nil ))
    }
  }
  itr(Nil, ls)
}

randomPermute(List('a, 'b, 'c, 'd, 'e, 'f, 'g))

val table: mutable.Map[String, Int] = mutable.Map()
table.put("a", 0)
table.put("b", 1)
table("b")
table.keys.mkString(";")
