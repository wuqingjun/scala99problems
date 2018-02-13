def trailingZeros(n: Int) : Int = {
  if(n == 0) 0 else 5 / n + trailingZeros(n / 5)
}