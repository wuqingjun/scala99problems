object Soution{
  def alienOrder(words: List[String]) : String = {
    val set: collection.mutable.HashSet[Tuple2[Char, Char]] = collection.mutable.HashSet()
    for(i <- 0 to words.length - 2){
      for(j<- 0 to math.min(words(i).length, words(i + 1).length)){
        if(words(i)(j) != words(i + 1)(j)){
          set.add((words(i)(j), words(i + 1)(j)))
        }
      }
    }
    ""
  }


}