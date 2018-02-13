def msort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {
  def merge(xs: List[T], ys: List[T]) : List[T] = (xs, ys) match{
    case (Nil, _) => ys
    case (_, Nil) => xs
    case (x :: xs1, y :: ys1) => if(less(x, y)) x :: merge(xs1, ys) else y :: merge(xs, ys1)
  }

  val n = xs.length / 2
  if( n == 0) xs
  else {
    val (ys, zs) = xs splitAt n
    merge(msort(less)(ys), msort(less)(zs))
  }
}


msort((x: Int, y: Int) => x < y) (List(5, 7, 1, 3))


val intSort = msort((x: Int, y: Int) => x < y) _
intSort(List(5, 7, 1, 3))

val reverseSort = msort((x: Int, y: Int) => x > y) _
reverseSort(List(5, 7, 1, 3))


List(1, 2, 3, 4) map(_ + 1)

val words = List("the", "quick", "brown", "fox")

words map (_.length)
words map (_.toList.reverse.mkString(""))

words map (_.toList)

words flatMap (_.toList)

def sum(xs: List[Int]) : Int = (0 /: xs)(_ + _)

sum(List(1, 2, 3, 4))

def product(xs: List[Int]): Int = (1 /: xs)( _ * _)
product(List(1, 2, 3, 4))


("" /: words)(_ + " " + _)

(words.head /: words.tail) (_ + " " + _)

def flatten1[T](xss: List[List[T]]) = (List[T]() /: xss) (_ ::: _)
def flatten2[T](xss: List[List[T]]) = (xss :\ List[T]()) (_ ::: _)
flatten1(List(List(1, 2), List(3, 4, 5), List(5, 6, 7)))
flatten2(List(List(1, 2), List(3, 4, 5), List(5, 6, 7)))

def reverse2[T](xs: List[T]) = (List[T]() /: xs) {(xs, x) => x :: xs}

reverse2(List(1, 2, 3, 4))

List.range(1, 5)

List.range(9, 1, -3)

val zipped = "abcde".toList zip List(1, 2, 3)

zipped.unzip



