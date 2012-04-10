package se.diversify.trollcount

/*Exception that should be thrown if the user uses TrollNumbers that are bigger then what a troll can grasp */
class TrollsDontDoBigNumbersException extends Exception

/**This class allows creating troll numbers, as well as adding them to each other. For example:
 * {{{
 * val two = Two
 * val five = Many-One
 * val fourteen = five + Many-Many-One
 * }}}
 * @param value the numeric value of this [[se.diversify.trollcount.TrollNumber]]
 */
class TrollNumber private[trollcount](val value: Int) {
  override def toString: String = value match {
    case 1 => "One"
    case 2 => "Two"
    case 3 => "Three"
    case 4 => "Many"
    case 16 => "Lots"
  }

  /**Allows joining [[se.diversify.trollcount.TrollNumber]]s together, for example:
   * {{{
   * val five = Many-One
   * val eleven = Many-Many-Three
   * }}}
   * @param other the other [[se.diversify.trollcount.TrollNumber]] to join with this one
   * @return a new [[se.diversify.trollcount.TrollNumber]] with this one combined with the other
   */
  def -(other: TrollNumber): TrollNumber = this + other

  /**Allows adding one [[se.diversify.trollcount.TrollNumber]] to another, for example:
   * {{{
   * val three = One + Two
   * val twelve = Many-Many-One + Three
   * }}}
   * @param other the other [[se.diversify.trollcount.TrollNumber]] to add to this one
   * @return a new [[se.diversify.trollcount.TrollNumber]] with this one added to the other
   */
  def +(other: TrollNumber): TrollNumber = TrollNumber(this.value + other.value)

}

/**Allows creating simple and complex troll numbers, as well as converting [[scala.Int]]s to
 * [[se.diversify.trollcount.TrollNumber]]s and vise verse
 */
object TrollNumber {
  val One = new TrollNumber(1)
  val Two = new TrollNumber(2)
  val Three = new TrollNumber(3)
  val Many = new TrollNumber(4)
  val Lots = new TrollNumber(16)

  private[trollcount] def apply(i: Int): TrollNumber = int2TrollNumber(i)

  /**Allows converting a [[se.diversify.trollcount.TrollNumber]] into an [[scala.Int]]
   * @param tn the [[se.diversify.trollcount.TrollNumber]] to convert
   * @return the [[se.diversify.trollcount.TrollNumber]] value as an [[scala.Int]]
   */
  implicit def TrollNumber2Int(tn: TrollNumber): Int = tn.value

  /**Allows converting an [[scala.Int]] into a [[se.diversify.trollcount.TrollNumber]]
   * @param i the [[scala.Int]] to convert
   * @return the [[scala.Int]]'s value as a [[se.diversify.trollcount.TrollNumber]]
   */
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

