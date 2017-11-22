import scala.collection.mutable

def findMaxLength(nums: List[Int]) : Int = {
  val mp: collection.mutable.HashMap[Int, Int] = new mutable.HashMap()
  var res = 0
  var sum = 0
  for(i <- 0 until nums.length){
    sum = sum + (if(nums(i) == 1) 1 else -1)
    if(mp.contains(sum)) res = Math.max(res, i - mp(sum))
    else mp(sum) = i
  }
  res
}