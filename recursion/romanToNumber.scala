import scala.collection.immutable.ListMap

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

def romanToNumber(s: String): Int = {  
  val romanMappingKeys = orderedRomanMapping.keys
  var sb = new StringBuilder(s)
  var number = 0
  
  def romanToNumberHelper(sb: StringBuilder, n: Int): Int =
    if (sb.length == 0) {
      // It is necessary to store the final result in a variable external to the function.
      // At this point the recursion will pop the accumulated stacks one by one and the final value of n will be 0.
      // It is mandated by the compiler to make the else branch return a value in order to be consistent with the function return type;
        // this is because there is an if branch without an else, so if the recursive call is never made in the if it will return nothing (Unit)
      number = n
      n
    }
    else {
      // A better strategy would be to abstract away the search of the key to detangle the interaction between
      // loop logic and recursion which may provide undesirable effects.
      // The inverse of this problem handles this problem well by defining an MCD function which finds the right key

      // Note that in this case this logic works because a StringBuilder has been used and at the end of the recursion
      // the buffer is empty. If it was not, the loop would continue to cycle for those map entries after the matched 
      // one which triggered the recursion and we would get a wrong result.      
      for (key <- romanMappingKeys)
        if (sb.indexOf(key) == 0)
          romanToNumberHelper(sb.delete(0, key.length), romanMapping(key) + n)
      number
    }  
  
  val n = romanToNumberHelper(sb, 0)
  println(n)
  n
}
