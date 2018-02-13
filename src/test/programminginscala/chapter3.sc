import scala.collection.mutable

(1).+(2)
(3).*(5)

val greetingStrings = new Array[String](3)
greetingStrings.foreach(println)
greetingStrings.update(0, "hello")
greetingStrings.foreach(println)
greetingStrings(1) = ","
greetingStrings.update(2, "world")

for(i <- 0.to(2)) print(greetingStrings.apply(i))
greetingStrings.foreach(println)
println(greetingStrings.toString)



val oneTwo = List(1, 2)
val threeFour = List(3, 4)

val ontTwoThreeFour = oneTwo ::: threeFour

val twoThree = List(2, 3)


val oneTwoThree = 1 :: 2 :: 3 :: Nil


val jetSet = new mutable.HashSet[String]
jetSet += "Lear"
jetSet += ("Boeing", "Airbus")

println(jetSet)


val movieSet = Set("Hitch", "Poltergeist", "Shrek")

val treasureMap = new mutable.HashMap[Int, String]
treasureMap += (1 -> "Go to island")

var tomato = 7

var tomahto = tomato

tomahto.equals(tomato)

tomato = 8
tomahto.equals(tomato)

println (tomahto)


class ChecksumCalculator{
  var sum: String = ""
}

val cc = new ChecksumCalculator
val dd = new ChecksumCalculator
cc.sum = "4"
dd.sum = "4"
cc.sum eq dd.sum
cc.sum.hashCode
dd.sum hashCode