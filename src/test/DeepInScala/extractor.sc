trait User{
  def Name: String
  def Score: Int
}

class FreeUser(val Name: String, val Score: Int, val upgradeProbability: Double) extends User
class PreUser(val Name: String, val Score: Int) extends User

object FreeUser{
  def unapply(arg: FreeUser): Option[(String, Int, Double)] = Some((arg.Name, arg.Score, arg.upgradeProbability))
}

object PreUser{
  def unapply(arg: PreUser): Option[(String, Int)] = Some((arg.Name, arg.Score))
}


object premiumCandidate{
  def unapply(arg: FreeUser): Boolean = arg.upgradeProbability > 0.5
}

val user: User = new FreeUser("PremiumDaniel", 300, 0.7d)
val user1: User = new PreUser("PremiumDaniel", 300)
user1 match {
  case FreeUser(name, score, grade) => if(grade > 0.7) name + "what can I do for you, " else "hello " + name
  case name PreUser score => "welcome back dear " + name
}

val user2: User = new FreeUser("PremiumDaniel", 300, 0.7d)
user2 match {
  case freeUser @ premiumCandidate() => "candidate " + freeUser.Name
  case _ => "welcome back dear " + user2.Name
}

val xs = 58 #:: 43 #:: 93 #:: Stream.empty
xs match {
  case first #:: second #:: _ => first - second
  case _ => -1
}

object #::{
  def unapply[A](xs: Stream[A] ): Option[(A, Stream[A])] = {
    if(xs.isEmpty) None
    else {println("customized!"); Some((xs.head, xs.tail))}
  }
}
val xs1 = 58 #:: 43 #:: 93 #:: Stream.empty
xs1 match {
  case first #:: second #:: _ => first - second
  case _ => -1
}


object ::{
  def unapply[A](ls: List[A]): Option[(A, List[A])] = {
    if(ls.isEmpty) None
    else {println("customized!"); Some(ls.head, ls.tail)}
  }
}


val ls0 = 1 :: 2 :: 3 :: List.empty

ls0 match{
  case first :: second :: _ => first + second
  case _ => -1
}


