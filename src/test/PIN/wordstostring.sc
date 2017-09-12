def wordstostring(words: List[String]) : String = {
  var res: String = new String
  var count: Int = 0
  for(i <- words.length - 1 to 0 by -1){
    if(!words(i).isEmpty){
      if(count == 0) res += words(i)
      else if(count == 1) res = words(i) + ", and " + res
      else res = words(i) + ", " + res
      count += 1
    }
  }
  res
}


wordstostring(List("Hello", "World"))
wordstostring(List("Hello", "World", "Wade"))
wordstostring(List("Hello", "", "World", "", "Wade"))
wordstostring(List("", "", "", "", "Wade"))


