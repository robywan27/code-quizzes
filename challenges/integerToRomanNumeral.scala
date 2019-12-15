val romanMapping = Map(
  1000 -> "M",
  900 -> "CM",
  500 -> "D",
  400 -> "CD",
  100 -> "C",
  90 -> "XC",
  50 -> "L",
  40 -> "XL",
  10 -> "X",
  9 -> "IX",
  5 -> "V",
  4 -> "IV",
  1 -> "I"
)


def integerToRomanNumeral(n: Int): String = {
  def loopHelper(n: Int, romanNumeral: String): String = {
    if (n == 0)
      romanNumeral
    else {      
      val key = mcd(n)
      loopHelper(n % key, romanNumeral + romanMapping(key) * (n / key))
    }    
  }

  loopHelper(n, "")
}

def mcd(n: Int): Int = {
  var max = 0
  val romanMappingKeys = romanMapping.keys  
  for (k <- romanMappingKeys)
    if (n / k != 0 && k > max)
      max = k
  max
}