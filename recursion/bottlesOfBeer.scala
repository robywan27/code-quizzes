def bottlesOfBeer(n: Int): Unit = {
	if (n == 0)	println("no more bottles of beer on the wall")	
	else {
		println(s"$n bottles of beer on the wall")
		bottlesOfBeer(n - 1)
	}
}
