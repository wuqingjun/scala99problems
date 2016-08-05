def flatten_flatMap(list: List[Any]): List[Any] = list.flatMap(el => el match {
  case xs: List[Any] => flatten_flatMap(xs)
  case _ => List(el)
})


def flatten(ls: List[Any]): List[Any] = ls.flatMap(e1 => e1 match{
  case xs: List[Any] => flatten(xs)
  case _ => List(e1)
})

def flatten2(ls: List[Any]): List[Any] = ls flatMap {
  case xs: List[Any] => flatten(xs)
  case e => List(e)
}
