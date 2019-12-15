import scala.collection.immutable.ListMap
import util.control.Breaks._

val romanMapping = Map(
  "M" -> 1000,
  "CM" -> 900,
  "D" -> 500,
  "CD" -> 400,
  "C" -> 100,
  "XC" -> 90,
  "L" -> 50,
  "XL" -> 40,
  "X" -> 10,
  "IX" -> 9,
  "V" -> 5,
  "IV" -> 4,
  "I" -> 1
)

val orderedRomanMapping = ListMap(romanMapping.toSeq.sortBy(_._2).reverse:_*)



def romanNumeralToInteger(romanNumeral: String): Int = {
  var result = 0


  @annotation.tailrec
  def loopHelper(numeral: String, integer: Int): Int = {  
    def findMatch: (String, Int) = {
      var key = ""
      var value = 0      
      breakable {
        for ((k, v) <- orderedRomanMapping) {
          if (numeral.startsWith(k)) {
            key = k
            value = v
            break
          }
        }
      }
      (key, value)
    }

    if (numeral == "")
      integer
    else {      
      val keyValue = findMatch
      val key = keyValue._1
      val value = keyValue._2
      loopHelper(numeral.substring(key.length, numeral.length), integer + value)      
    }
  }
  

  loopHelper(romanNumeral, 0)  
}
