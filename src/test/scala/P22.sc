def range(first: Int, last: Int) : List[Int] = {
    def itr(ls: List[Int], f: Int, l: Int) : List[Int] = l - f match {
        case -1 => ls ::: Nil
        case _ => { println(f); itr(ls ::: List(f), f + 1, l); }
    }
    itr(Nil, first, last)
}

range(4, 9)

def rangeBuiltin(start: Int, end: Int) : List[Int] = List.range(start, end)

rangeBuiltin(4, 9)

def rangeR(first: Int, last: Int) : List[Int] = {
    def itr(ls: List[Int], l: Int) : List[Int] = l >= first match{
        case true => itr(l :: ls, l - 1)
        case false => ls
    }
    itr(Nil, last)
}

rangeR(4, 9)




