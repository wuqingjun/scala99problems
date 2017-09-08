
def lsort[A](ls: List[List[A]]) : List[List[A]] = ls.sortWith( _.length < _.length)

lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))