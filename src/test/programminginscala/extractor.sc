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

Email.unapply("nihao@ffss.org") match {
  case Some((u, d)) => Email(u, d)
}
