def duplicate[A](ls: List[A]): List[A] = ls flatMap(e => List(e, e))

duplicate(List('a, 'b, 'c, 'c, 'd))

def duplicateLeft[A](ls: List[A]) : List[A] = ls.foldLeft(List[A]())((B, A) => B ++ List.fill(2)(A))
duplicateLeft(List('a, 'b, 'c, 'c, 'd))


def duplicateRight[A](ls: List[A]) : List[A] = ls.foldRight(List[A]())((A, B) => List(A, A) ++ B)

duplicateRight(List('a, 'b, 'c, 'c, 'd))

