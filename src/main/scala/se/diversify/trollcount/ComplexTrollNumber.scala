package se.diversify.trollcount

import scala.language.implicitConversions

/** Represents a complex [[se.diversify.trollcount.TrollNumber]], such as `Many-Many-One`
  * @param trollNumbers a List of [[se.diversify.trollcount.TrollNumber]]s which builds this complex [[se.diversify.trollcount.TrollNumber]]
  */
class ComplexTrollNumber private[trollcount](trollNumbers: List[TrollNumber]) extends TrollNumber(trollNumbers.foldLeft(0)(_ + _)) {
  /** Describes this [[se.diversify.trollcount.ComplexTrollNumber]] */
  override def toString: String = trollNumbers.mkString("-")
}

/** Allows converting an `Int` into a [[se.diversify.trollcount.ComplexTrollNumber]] */
object ComplexTrollNumber {
  /** Allows converting an `Int` into a [[se.diversify.trollcount.ComplexTrollNumber]]
    * @param i the `Int` to convert
    * @return the converted [[se.diversify.trollcount.ComplexTrollNumber]]
    */
  implicit def int2ComplexTrollNumbers(i: Int): TrollNumber = {
    val manys = i / 4
    val rest = i - manys * 4
    val list = List.fill(manys)(TrollNumber.Many)
    if (rest == 0) new ComplexTrollNumber(list)
    else new ComplexTrollNumber(list :+ TrollNumber(rest))
  }
}
