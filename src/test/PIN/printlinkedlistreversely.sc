def printLinkedListReversely(ls: collection.mutable.MutableList[Int]): Unit = ls.headOption match {
  case Some(x) => {
    printLinkedListReversely(ls.tail)
    println(ls.headOption get)
  }
  case _ => {}
}

val ls: collection.mutable.MutableList[Int] = collection.mutable.MutableList()
ls += 1
ls += 2
ls += 3

printLinkedListReversely(ls)
