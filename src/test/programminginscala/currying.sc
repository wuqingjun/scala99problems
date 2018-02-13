def curriedSum(x: Int)(y: Int) = x + y

val x = curriedSum(0)(2)

def first(x: Int) = (y: Int) => x + y
val second = first(1)
second(2)


val onePlus = curriedSum(1)_
onePlus(2)


val twoPlus = curriedSum(2)_
twoPlus(2)