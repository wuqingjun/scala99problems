object Email extends ((String, String) => String){
  def apply(user: String, domain: String) =  { println ("applying..."); user + "@" + domain }
  def unapply(str: String): Option[(String, String)] = {
    println("unapplying...")
    val parts = str split "@"
    if(parts.length == 2) Some(parts(0), parts(1)) else None
  }
}

Email.unapply("john@gmail.com")

"john@gmail.com" match {
  case Email(user, domain) => println(user + "@" + domain)
}

val x: Any = "hello@hotmail.com"
x match  {
  case Email(user, domain) => println(x)
}

val y: Any = 50
y match {
  case Email(user, domain) => println(x)
  case _ => "nothing"
}

(Email.unapply("nihao@ffss.org") : @unchecked) match {
  case Some((u, d)) => Email(u, d)
}

object Twice{
//  def apply(s: String): String = s + s

  def unapply(s: String): Option[String] = {
    val length = s.length / 2
    val half = s.substring(0, length)
    if(half == s.substring(length)) Some(half) else None
  }
}

("hellohello": @unchecked) match{
  case Twice(h) => println(h)
}

object UpperCase{
  def unapply(arg: String): Boolean = arg.toUpperCase == arg
}

("HeLLO": @unchecked) match {
  case UpperCase() => println("UPPER CASE")
  case _ => println("Not UPPER CASE")
}

def userTwiceUpper(s: String) = s match{
  case Email(Twice(x @UpperCase()), domain) => "match: " + x + " in domain"
  case _ => "no match"
}

object Domain{
  def apply(parts: String*): String = parts.reverse.mkString(".")
  def unapplySeq(arg: String): Option[Seq[String]] = Some(arg.split("\\.").reverse)
}


def isTomInDotCom(s: String): Boolean = s match{
  case Email("tom", Domain("com", _*)) => true
  case _ => false
}

isTomInDotCom("tom@sun.com")
isTomInDotCom("peter@sun.com")
isTomInDotCom("tom@acm.org")

object ExpandedEmail{
  def unapplySeq(email: String) : Option[(String, Seq[String])] = {
    val parts = email split "@"
    if(parts.length == 2) Some(parts(0), parts(1).split("\\.").reverse)
    else None
  }
}


val s = "tom@support.epfl.ch"
val ExpandedEmail(name, topdom, subdoms @ _*) = s