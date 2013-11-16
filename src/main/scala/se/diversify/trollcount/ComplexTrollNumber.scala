package se.diversify.trollcount

import scala.language.implicitConversions
import TrollNumber._

/** Represents a complex [[se.diversify.trollcount.TrollNumber]], such as Many-Many-One
  * @param trollNumbers a List of [[se.diversify.trollcount.TrollNumber]]s which builds this complex [[se.diversify.trollcount.TrollNumber]]
  */
class ComplexTrollNumber private[trollcount](trollNumbers: List[TrollNumber]) extends TrollNumber(trollNumbers.foldLeft(0)(_ + _)) {
  /** Describes this [[se.diversify.trollcount.ComplexTrollNumber]] */
  override def toString: String = "" // TODO return correct representation
}

/** Allows converting an `Int` into a [[se.diversify.trollcount.ComplexTrollNumber]] */
object ComplexTrollNumber {
  /** Allows converting an `Int` into a [[se.diversify.trollcount.ComplexTrollNumber]]
    * @param i the `Int` to convert
    * @return the converted [[se.diversify.trollcount.ComplexTrollNumber]]
    */
  implicit def int2ComplexTrollNumbers(i: Int): TrollNumber = One // TODO return something like Many-One or Many-Many-Three etc
}
