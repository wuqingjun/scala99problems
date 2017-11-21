import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Random, Try}
import scala.concurrent.ExecutionContext.global
implicit val ec = ExecutionContext.global

type CoffeeBeans = String
type GroundCoffee = String
case class Water(temparture: Int)
type Milk = String
type FrothedMilk = String
type Espresso = String
type Cappucino = String

def grind(beans: CoffeeBeans): Future[GroundCoffee] =  Future {
  println("start grinding")
  Thread.sleep(Random.nextInt(2000))
  println("finished grinding")
  s"ground coffee of $beans"
}

def heatWater(water: Water): Future[Water] = Future{
  println("heating water now")
  Thread.sleep(Random.nextInt(2000))
  println("hot, it's hot")
  water.copy(temparture = 85)
}

def frothMilk(milk: Milk): Future[FrothedMilk] = Future{
  println("milk frothing system engaged")
  Thread.sleep(Random.nextInt(2000))
  println("shutting down frothing system")
  s"frothed $milk"
}

def brew(coffee: GroundCoffee, heatedWater: Water): Future[Espresso] = Future {
  println("happy brewing")
  Thread.sleep(Random.nextInt(2000))
  println("it's brewed!")
  "espresso"
}

def combine(espresso: Espresso, frothedMilk: FrothedMilk): Cappucino = "cappucino"

case class GrindingException(msg: Exception) extends Exception(msg)
case class FrothingException(msg: Exception) extends Exception(msg)
case class WaterBoilingException(msg: Exception) extends Exception(msg)
case class BrewingException(msg: Exception) extends Exception(msg)

grind("baked beans").onSuccess{ case ground => println(ground) }



