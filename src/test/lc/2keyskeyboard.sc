  def minSteps(n: Int) : Int = {
      var res: Int = Int.MaxValue
      def rec(s: Int, total: Int, copy: Int) : Unit ={
          if(total == n){
            res = math.min(res, s)
          }
          else if(total < n){
            rec(s + 2, total * 2, total)
            rec(s + 1, total + copy, copy)
          }
        }
      rec(2, 2, 1)
    res
  }

  minSteps(3)
