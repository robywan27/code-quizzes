package recursion

object Flatten {
	def flatten(l: List[Any]): List[Any] =
		l match {
			case Nil => Nil
			case (x :: xs) => x match {
				case (y :: ys) => flatten(List(y)) ++ flatten(ys) ++ flatten(xs)
				case _ => x :: flatten(xs)
			}
		}
}