import scala.io.Source

object Challenge {
	/*def decreasingGDP(entries: List[Float]): Int = {
		
		def helper(entries: List[Float], counter: Int): Int = {			
			entries match {
				case Nil => counter
				case (x :: Nil) => helper(Nil, counter)
				case (x :: y :: xs) => {
					if (x > y)		helper(y :: xs, counter + 1)
					else helper(y :: xs, counter)
				}
			}
		}

		helper(entries, 0)		
	}
*/
	/*def decreasingGDP(entries: List[(String, Float)]): Int = {

	}*/

	def groupByYear(entries: List[(String, Float)]): List[(String, List[Float])] = {
		val distinctYears = entries.map(_._1.substring(0, 4)).toSet
		var lb = new scala.collection.mutable.ListBuffer[(String, Float)]()
		for (year <- distinctYears)
			lb += (year, entries.filter(_._1 == year).map(_._2))
		lb.toList
	}	

	def getUS_GDPs: List[(String, Float)] = {
		val filePath = "input/us_gdp.csv"
		val bufferedSource = Source.fromFile(filePath)

		val csvEntries = bufferedSource
			.getLines()
			.toList
			.map(_.split(","))
		csvEntries.tail.map(x => (x(0), x(1).toFloat))
		// csvEntries.tail.map(x => x(1).toFloat)
	}

	def main(args: Array[String]): Unit = {
			val usGDPs = getUS_GDPs			
			println(groupByYear(usGDPs))
	}
}