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

var numeral = new StringBuilder("")


def numberToRoman(n: Int): String = {	
	val key = mcd(n)	
	for (i <- 0 until (n / key))
		numeral.append(romanMapping(key))
	val remainder = n % key
	if (remainder == 0)		numeral.toString()
	else numberToRoman(remainder)
}

def mcd(n: Int): Int = {
	var max = 0
	val romanMappingKeys = romanMapping.keys	
	for (k <- romanMappingKeys)
		if (n / k != 0 && k > max)
			max = k
	max
}