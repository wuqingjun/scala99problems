import java.util.NoSuchElementException

import scala.util.Random

class o1timerandomdatastructure() {
  val nums:  collection.mutable.ArrayBuffer[Int] = collection.mutable.ArrayBuffer()
  val mp: collection.mutable.HashMap[Int, collection.mutable.ArrayStack[Int]] = collection.mutable.HashMap()
  def add(n: Int): Unit = {
    nums += n
    if(!mp.contains(n)) mp += (n -> new collection.mutable.ArrayStack[Int])
    mp(n).push(nums.length - 1)
  }
  def remove(n: Int): Unit = {
    if(mp.contains(n)){
      nums(mp(n).top) = nums.last
      nums.remove(nums.length - 1)
      mp(n).pop()
    }
  }

  def random() : Int = nums.isEmpty match {
    case false => nums(Random.nextInt(nums.length))
    case _ => throw new NoSuchElementException
  }
}

val r: o1timerandomdatastructure = new o1timerandomdatastructure()
r.add(1)
r.random()
r.add(2)
r.add(2)
r.add(3)
r.random()
r.random()
