abstract class CurrencyZone{
  type Currency <: AbstractCurrency
  def make(x: Long): Currency

  abstract class AbstractCurrency{
    val amount:  Long
    def destination: String
    override def toString = amount + " " + destination
    def + (that: Currency): Currency =
      make(this.amount + that.amount)

    def * (x:  Double):  Currency = {
      make((this.amount * x).toLong)
    }
  }
}


object US extends CurrencyZone{
  abstract class Dollar extends AbstractCurrency{
    def destination = "USD"
  }
  type Currency = Dollar
  def make(x: Long) = new Dollar {
    override val amount= x
  }

  val Cent = make(1)
  val Dollar = make(100)
  val CurrencyUnit = Dollar
}

object European extends CurrencyZone{
  abstract class Euro extends AbstractCurrency{
    override def destination: String = "Euro"
  }

  type Currency = Euro
  def make(x: Long) = new Euro{ override val amount = x}
  val Euro = make(100)
  val Cent = make(1)
  val CurrencyUnit = Euro
}


US.make(10)
European.make(1000)
