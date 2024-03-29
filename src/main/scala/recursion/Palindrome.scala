package recursion

object Palindrome {
	// Recursive
	def palindromeRec(s: String): Boolean = {
		val n = s.length

		@scala.annotation.tailrec
		def palindromeHelper(s: String, i: Int): Boolean = {
			if (i == n) true
			else if (s(i) == s(n - 1 - i))
				palindromeHelper(s, i + 1)
			else false
		}

		palindromeHelper(s, 0)
	}


	// Imperative
	def palindromeIter(s: String): Boolean = {
		val n = s.length
		for (i <- 0 until n)
			if (s(i) != s(n - 1 - i)) return false
		true
	}
}