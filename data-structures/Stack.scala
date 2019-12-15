class Stack(l: List[Any]) = {
	def push(e: Any): List[Any] = e :: l
	def pop: List[Any] = l.tail
}