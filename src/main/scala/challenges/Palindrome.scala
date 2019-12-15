package challenges

import scala.io.Source
import collection.mutable.ListBuffer

object Palindrome {
	def findPalindrome(names: List[String]): String = {
		def palindrome(name: String): Boolean = {
			val n = name.length
			for (i <- 0 until n)
				if (name(i) != name(n - 1 - i))
					return false
			true
		}

		// The exercise guarantees there is only onw palindrome
		names.filter(palindrome).head
	}

	def getInputNames: List[String] = {
	    val filePath = "input/names.txt"
	    val bufferedSource = Source.fromFile(filePath)

	    val namesBuf = new ListBuffer[String]
	    for (name <- bufferedSource.getLines()) {
	      namesBuf += name
	    }

	    bufferedSource.close()
	    List(namesBuf.toList: _*)
  }

	def main(args: Array[String]): Unit = {		
		println(findPalindrome(getInputNames))
	}
}