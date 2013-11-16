import org.specs2.mutable.Specification
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import se.diversify.trollcount.TrollNumber._
import se.diversify.trollcount.TrollsDontDoBigNumbersException
import scala.language.implicitConversions

@RunWith(classOf[JUnitRunner])
class TrollNumberSpec extends Specification {

  "TrollNumber" should {

    "return correct value for simple TrollNumbers" in {
      One.value mustEqual 1
      Two.value mustEqual 2
      Three.value mustEqual 3
      Many.value mustEqual 4
      Lots.value mustEqual 16
    }

    "return correct toString for simple TrollNumbers" in {
      One.toString mustEqual "One"
      Two.toString mustEqual "Two"
      Three.toString mustEqual "Three"
      Many.toString mustEqual "Many"
      Lots.toString mustEqual "Lots"
    }

    "allow creating complex TrollNumbers" in {
      (Many-Two).value mustEqual 6
      (Many-Two).toString mustEqual "Many-Two"
      (Many-Many-Three).value mustEqual 11
      (Many-Many-Three).toString mustEqual "Many-Many-Three"
    }

    "throw exception for too big TrollNumbers" in {
      (Many-Many-Many-Many-Many) must throwA [TrollsDontDoBigNumbersException]
    }

    "allow adding TrollNumbers" in {
      (Three + Two).value mustEqual 5
      (Three + Two).toString mustEqual "Many-One"
      (Many-Three + Two).value mustEqual 9
      (Many-Three + Two).toString mustEqual "Many-Many-One"
      (Many-Many-Two + Many-Two).value mustEqual 16
      (Many-Many-Two + Many-Two).toString mustEqual "Lots"
    }

    "throw exception when adding too big TrollNumbers" in {
      (Many-Many + Many-Many + One) must throwA [TrollsDontDoBigNumbersException]
    }
  }

}
