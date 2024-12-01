import kotlin.math.abs

fun main() {
    val testInput = readInput("Day01_test")
    part1(testInput).println() // 11
    part2(testInput).println() // 31

    val input = readInput("Day01")
    part1(input).println() // 1388114
    part2(input).println() // 23529853
}

fun part1(input: List<String>): Int {
    val (leftIds, rightIds) = parseIds(input)

    return leftIds.sorted()
        .zip(rightIds.sorted())
        .sumOf { (left, right) -> abs(left - right) }
}

fun part2(input: List<String>): Int {
    val (leftIds, rightIds) = parseIds(input)

    val rightCounts = rightIds.groupingBy { it }.eachCount()

    return leftIds.sumOf { leftId -> leftId * (rightCounts[leftId] ?: 0) }
}

fun parseIds(input: List<String>) = input.fold(emptyList<Int>() to emptyList<Int>()) { (leftList, rightList), line ->
    val (left, right) = line.split("   ").map(String::toInt)
    leftList + left to rightList + right
}