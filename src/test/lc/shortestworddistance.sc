def wordDistance(words: List[String], word1: String, word2: String) : Int = {
  var i1 = -1
  var i2 = -1
  var wc = 0
  var res = Int.MaxValue
  for(i <- 0 until words.length) {
    if(words(i) == word1) { if(i1 < 0) wc += 1;  i1 = i; }
    else if(words(i) == word2) {if(i2 < 0) wc += 1; i2 = i; }
    if(wc == 2){
      res = Math.min(res, Math.abs(i1 - i2))
    }
  }
  res
}

