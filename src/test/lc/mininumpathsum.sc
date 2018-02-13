import scala.collection.mutable.ArrayBuffer

def minimumPathSum(grid: List[List[Int]]) : Int = {
  val m = grid.length
  val n = grid(0).length

  val dp = ArrayBuffer.fill(m, n)(0)
  for(i <- 0 until m){
    for(j <- 0 until n){
      dp(i)(j) = if (i == 0 && j == 0) grid(0)(0) else if(i == 0) dp(i)(j - 1) + grid(i)(j) else if(j == 0) dp(i - 1)(j) + grid(i)(j) else grid(i)(j) + Math.min(dp(i - 1)(j), dp(i)(j - 1))
    }
  }
  dp(m - 1)(n - 1)
}


minimumPathSum(List(List(3, 1, 4), List(2, 5, 2)))