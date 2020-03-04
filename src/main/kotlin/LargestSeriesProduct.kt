class Series(private val input: String) {

    init {
        require(input.all { it.isDigit() })
    }

    fun getLargestProduct(span: Int): Long {

        require(span >= 0 && span <= input.length)

        if (span == 0) return 1

        return input.map { it.toString().toLong() }
                .windowed(span)
                .map { it.fold(1.toLong()) { acc, digit -> acc * digit} }
                .max()!!
    }
}
