package se.diversify.trollcount

class ComplexTrollNumber(trollNumbers: List[TrollNumber]) extends TrollNumber(trollNumbers.foldLeft(0)(_ + _)) {

  override def toString: String = trollNumbers.mkString("-")
}

object ComplexTrollNumber {

  implicit def int2ComplexTrollNumbers(i: Int): TrollNumber = {
    val manys = i / 4
    val rest = i - manys * 4
    val list = List.fill(manys)(TrollNumber.Many)
    if (rest == 0) new ComplexTrollNumber(list)
    else new ComplexTrollNumber(list :+ TrollNumber(rest))
  }
}
