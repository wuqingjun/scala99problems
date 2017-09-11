def leastWords(input: String, dict: scala.collection.immutable.HashSet[String]) : Int = {
  val dp = Array.ofDim[Int](input.length, input.length)
  for(l <- 1 to input.length; i <- 0 to input.length - l ) {
    dp(i)(l - 1) = if(dict.contains(input.substring(i, l))) 1 else input.length + 1
    for(j <- 1 until l){
      dp(i)(l - 1) = dp(i)(j - 1) + dp(i + j)(l - j - 1)
    }
  }

  if(dp(0)(input.length - 1) < input.length + 1) dp(0)(input.length - 1) else -1
}

