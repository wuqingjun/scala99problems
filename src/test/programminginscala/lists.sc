val fruits = "apples" ::("oranges" :: ("pears" :: Nil))
val List(a, b, c) = fruits
val d :: e :: f :: Nil= fruits

def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case List() => List(x)
  case y::ys => if(x <= y) x :: xs else y :: insert(x, ys)
}

def isort(xs: List[Int]): List[Int] = xs match{
  case List() => List()
  case x::xs1 => insert(x, isort(xs1))
}


isort(List(3, 1, 4,  2, 5, 6))

::(3, ::(2, Nil))

::(4, Nil)

::(1, List(3, 4))

val abcde = List('a', 'b', 'c', 'd', 'e')
abcde.last
abcde.init
abcde.head
abcde.tail

abcde sortWith ( _ > _)
