import scala.util.Try

type CoffeeBeans = String
type GroundCoffee = String
case class Water(temparture: Int)
type Milk = String
type FrothedMilk = String
type Espresso = String
type Cappucino = String

def grind(beans: CoffeeBeans): GroundCoffee = s"ground coffee of $beans"
def heatWater(water: Water): Water = water.copy(temparture = 85)
def frothMilk(milk: Milk): FrothedMilk = s"frothed $milk"
def brew(coffee: GroundCoffee, heatedWater: Water): Espresso = "espresso"
def combine(espresso: Espresso, frothedMilk: FrothedMilk): Cappucino = "cappucino"

case class GrindingException(msg: Exception) extends Exception(msg)
case class FrothingException(msg: Exception) extends Exception(msg)
case class WaterBoilingException(msg: Exception) extends Exception(msg)
case class BrewingException(msg: Exception) extends Exception(msg)


def prepareCappuccino(): Try[Cappucino] = for{
  ground <- Try(grind("arabica beans"))
  water <- Try(heatWater(Water(25)))
  espresso <- Try(brew(ground, water))
  foam <- Try(frothMilk("milk"))
} yield combine(espresso, foam)

prepareCappuccino()
