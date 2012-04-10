package se.diversify.trollcount

class TrollsDontDoBigNumbersException extends Exception

class TrollNumber private[trollcount](val value: Int) {

  override def toString: String = value match {
    case 1 => "One"
    case 2 => "Two"
    case 3 => "Three"
    case 4 => "Many"
    case 16 => "Lots"
  }

  def -(other: TrollNumber): TrollNumber = this + other

  def +(other: TrollNumber): TrollNumber = TrollNumber(this.value + other.value)

}

object TrollNumber {
  val One = new TrollNumber(1)
  val Two = new TrollNumber(2)
  val Three = new TrollNumber(3)
  val Many = new TrollNumber(4)
  val Lots = new TrollNumber(16)

  private[trollcount] def apply(i: Int): TrollNumber = int2TrollNumber(i)

  implicit def TrollNumber2Int(tn: TrollNumber): Int = tn.value

  implicit def int2TrollNumber(i: Int): TrollNumber = {
    if (i > 16) throw new TrollsDontDoBigNumbersException

    i match {
      case 1 => One
      case 2 => Two
      case 3 => Three
      case 4 => Many
      case 16 => Lots
      case _ => ComplexTrollNumber.int2ComplexTrollNumbers(i)
    }
  }
}

