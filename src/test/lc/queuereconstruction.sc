
def reconstructQueue(people: List[(Int, Int)]) : List[(Int, Int)] = {
  people.sortWith((a, b) => a._1 > b._1 || a._1 == b._1 && a._2 < b._2)
  .foldLeft(List[(Int, Int)]())((A, b) => A.take(b._2) ++ List(b) ++ A.drop(b._2) )
}

val p = reconstructQueue( List((7,0), (4,4), (7,1), (5,0), (6,1), (5,2)) )
