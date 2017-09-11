def timeDurationMax(data: Array[Array[Int]]) : Int = {
  case class duration(time: Int, timeType: Int, value: Int)
  val durations = data.foldLeft(List[duration]())((B, A) => duration(A(0), 1, A(2)) :: duration(A(1), -1, A(2)) :: B )
  val sorted = durations.sortBy(_.time)
  var res = 0
  sorted.foldLeft(0)((B, A) => {val t = A.timeType * A.value + B; res = math.max(res, t); t;} )
  res
}

val l =  Tuple3[Int, Int, Int](1,  2, 3) :: List[Tuple3[Int, Int, Int]]()

def timeDurationMax2(data: Array[Array[Int]]) : Int = {
  val durations = data.foldLeft(List[Tuple3[Int, Int,Int]]())((B, A) => Tuple3(A(0), 1, A(2)) :: (Tuple3(A(1), -1, A(2)) :: B) )
  val sorted = durations.sortBy(_._1)
  var res = 0
  sorted.foldLeft(0)((B, A) => {val t = A._1* A._2+ B; res = math.max(res, t); t;} )
  res
}
timeDurationMax2(Array(Array(1, 3, 100), Array(2, 4, 200), Array(5, 6, 300)))