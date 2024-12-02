package day01

import kotlin.math.abs

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

private fun parseIds(input: List<String>) = input.fold(emptyList<Int>() to emptyList<Int>()) { (leftList, rightList), line ->
    val (left, right) = line.split("   ").map(String::toInt)
    leftList + left to rightList + right
}