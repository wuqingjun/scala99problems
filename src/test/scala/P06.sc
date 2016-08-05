def isPalindrome[A](ls: List[A]) : Boolean = {
  def iter(a : Int, b : Int, ls: List[A]): Boolean = {
    if(a >= b) true
    else ls(a) == ls(b) && iter(a + 1, b - 1, ls)
  }
  iter(0, ls.length - 1, ls)

}

Nil.length
isPalindrome(Nil)
isPalindrome(List(0, 1, 2, 2, 1, 0))
isPalindrome(List(0, 1, 2, 1, 0))
isPalindrome(List(0, 1, 2, 2, 0))
