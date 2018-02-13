val increase: Int => Int = {case x: Int => x + 5}
val a = increase(7)
print(a)


val second: List[Int] => Int = {
  case x::y::_ => y
}

second(List(1, 2, 3))
//second(List())

val secondPar: PartialFunction[List[Int], Int] = {
  case x::y::_ => y
}

secondPar.isDefinedAt(List(1, 2, 3))
secondPar(List(4, 5, 6))
secondPar.isDefinedAt(List())

val results = List(Some("apple"), None, Some("orange"))
for(Some(fruit) <- results) println(fruit)