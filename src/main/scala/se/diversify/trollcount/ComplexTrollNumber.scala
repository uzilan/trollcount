package se.diversify.trollcount

import TrollNumber._

/**Represents a complex [[se.diversify.trollcount.TrollNumber]], such as Many-Many-One
 * @param trollNumbers a List of [[se.diversify.trollcount.TrollNumber]]s which builds this complex [[se.diversify.trollcount.TrollNumber]]
 */
class ComplexTrollNumber private[trollcount](trollNumbers: List[TrollNumber]) extends TrollNumber(trollNumbers.foldLeft(0)(_ + _)) {
  override def toString: String = "" // TODO return correct representation
}

/**Allows converting an [[scala.Int]] into a [[se.diversify.trollcount.ComplexTrollNumber]]*/
object ComplexTrollNumber {
  /**Allows converting an [[scala.Int]] into a [[se.diversify.trollcount.ComplexTrollNumber]]
   * @param i the [[scala.Int]] to convert
   * @return the converted [[se.diversify.trollcount.ComplexTrollNumber]]
   */
  implicit def int2ComplexTrollNumbers(i: Int): TrollNumber = One // TODO return something like Many-One or Many-Many-Three etc
}
