object Solution2 {
  def isMatch(s : String, p: String) : Boolean = p.toList match {
    case Nil => s.isEmpty
    case h :: '*' :: t => isMatch(s, p.substring(2)) || (!s.isEmpty && (s(0) == h  || h == '.' ) && isMatch(s.substring(1), p))
    case  _ =>  !s.isEmpty && (s(0) == p(0) || s(0) == '.') && isMatch(s.substring(1), p.substring(1))
  }
}

object Solution3 {
  def isMatch(s : List[Char], p: List[Char]) : Boolean = p match {
    case Nil => s.isEmpty
    case h :: '*' :: t => isMatch(s, t) || ( s match {
      case Nil => false
      case _ => (s.head == h || h == '.') && isMatch(s.tail, p)
    })
    case  _ =>  !s.isEmpty && (s.head == p.head || s.head == '.') && isMatch(s.tail, p.tail)
  }
}

"".toList
Nil.toList

Solution2.isMatch("aa", "a")
Solution2.isMatch("aa", "aa")
Solution2.isMatch("aaa", "aa")
Solution2.isMatch("aaa", "a*")
Solution2.isMatch("aaa", ".*")
Solution2.isMatch("ab", ".*")

Solution3.isMatch("aa".toList, "a".toList)
Solution3.isMatch("aa".toList, "aa".toList)
Solution3.isMatch("aaa".toList, "aa".toList)
Solution3.isMatch("aaa".toList, "a*".toList)
Solution3.isMatch("aaa".toList, ".*".toList)
Solution3.isMatch("ab".toList, ".*".toList)
