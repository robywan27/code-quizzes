package challenges

import scala.io.Source

object AddTheDigits {
	def sumDigits(numbers: List[String]): Int = {
		@annotation.tailrec
		def helper(numbers: List[String], res: Int): Int =
			numbers match {
				case Nil => res
				case (n :: ns) => helper(ns, res + n.toList.map(_.toString.toInt).sum)
			}		

		helper(numbers, 0)
	}

	def getNumbers: List[String] = {
		val filePath = "input/numbers.txt"
		val bufferedSource = Source.fromFile(filePath)

		bufferedSource.getLines().toList			
	}

	def main(args: Array[String]): Unit = {			
			println(sumDigits(getNumbers))
	}
}