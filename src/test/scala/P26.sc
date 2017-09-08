def combinations[A](k: Int, lst: List[A]): List[List[A]] = {
  var result: List[List[A]] = List[List[A]]()
  def itr(tmp: List[A], i: Int) : Unit = i == lst.length match{
    case true => if(tmp.length == k) result = tmp :: result
    case false => {
      itr(tmp, i + 1)
      itr(lst(i) :: tmp, i + 1)
    }
  }

  itr(Nil, 0)

  result
}


combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))

val table: collection.mutable.Map[Int, Int] = collection.mutable.Map()
table.put(1, 1)
table(1)

def flatMapSublists[A, B](ls: List[A])(f: (List[A]) => List[B]): List[B] = ls match{
  case Nil => Nil
  case sublist@(_ :: tail) => f(sublist) ::: flatMapSublists(tail)(f)
}

def comtinations2[A](n: Int, ls: List[A]) : List[List[A]] =
  if(n == 0) List(Nil)
  else flatMapSublists(ls) {
    sl =>
      val t = comtinations2(n - 1, sl.tail)
      t map ( sl.head :: _  )
  }


comtinations2(1, List('a, 'b, 'c, 'd, 'e, 'f))
