import scala.math
def printMatrix(m: Array[Array[Symbol]]) : Unit = {
  for(d <- 0 to m.length - 1){
    for(r <- 0 to m.length - 1 - d ){
      print(m(r)(r + d))
    }
    println("")
  }
  for(d <- 1 to m.length - 1){
    for(r <- d to m.length - 1){
      print(m(r)(r - d))
    }
    println("")
  }
}


printMatrix(Array(Array('a, 'b), Array('c, 'd)))