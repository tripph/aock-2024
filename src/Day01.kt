import kotlin.math.absoluteValue

fun main() {
    fun part1(input: List<String>): Int {
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()
        input.forEach {
            val split = it.split("   ")
            left.add(split[0].trim().toInt())
            right.add(split[1].trim().toInt())
        }
        left.sort()
        right.sort()
        val pairs = mutableListOf<Pair<Int,Int>>()
        left.forEachIndexed { index, l ->
            pairs.add(l to right[index])
        }
        return pairs.map { it.first.minus(it.second).absoluteValue }.sum()
    }

    fun part2(input: List<String>): Int {
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()
        input.forEach {
            val split = it.split("   ")
            left.add(split[0].trim().toInt())
            right.add(split[1].trim().toInt())
        }
        left.sort()
        right.sort()
        return left.mapIndexed { index, l -> l.times(right.count{r -> r == l})  }.sum()
    }


    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
