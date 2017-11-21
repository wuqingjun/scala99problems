def wordsWithoutOutliers(words: Seq[(String, Int)]) : Seq[String] = {
  words.filter {case (_, f) => f > 3 && f < 25} map {case(w, _) => w}
}

val wordFrequencies = ("habitual", 6) :: ("and", 56) :: ("consuetudinary", 2) ::
  ("additionally", 27) :: ("homely", 5) :: ("society", 13) :: Nil

wordsWithoutOutliers(wordFrequencies)

wordFrequencies.collect { case (w, f) if f > 3 && f < 25 => w}