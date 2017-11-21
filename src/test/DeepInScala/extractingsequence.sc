object GivenNames{
  def unapplySeq(name: String): Option[Seq[String]] = {
    val names = name.trim.split(" ")
    if(names.forall(_.isEmpty)) None else Some(names)
  }
}


def greetingWithFirstName(name: String) = name match {
  case GivenNames(firstName, _*) => "Good morning, " + firstName
  case _ => "Welcome, please fill in your names"
}


greetingWithFirstName("Catherina Johanna")

object Names{
  def unapplySeq(name: String): Option[(String, String, Seq[String])] = {
    val names = name.trim.split(" ")
    if(names.size < 2) None else Some((names.last, names.head, names.drop(1).dropRight(1)))
  }
}


def greet(fullName: String) = fullName match{
  case Names(last, first, _*) => "Good morning, " + first + " " + last + "!"
  case _ => "welcome, please fill your name first!"
}

greet("wade Wu")


def gameResults(): Seq[(String, Int)] =
  ("Daniel", 3500) :: ("Melissa", 13000) :: ("John", 7000) :: Nil

def hallOfFame = for {
  result <- gameResults()
  (name, score) = result
  if (score > 5000)
} yield name

hallOfFame

val lists = List(1, 2, 3) :: List.empty :: List(5, 3) :: Nil

for{
  list @ head :: _ <- lists
} yield list.size