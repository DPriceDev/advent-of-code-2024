package day02

import kotlin.math.abs

fun part1(input: List<String>) = input.count { line ->
    val differences = parseReport(line).zipWithNext { a, b -> b - a }
    checkReport(differences)
}

fun part2(input: List<String>) = input.count { line ->
    val report = parseReport(line)
    report.indices
        .map { report.filterIndexed { index, _ -> it != index }.zipWithNext { a, b -> b - a } }
        .any(::checkReport)
}

private fun parseReport(input: String) = input.split(" ").map(String::toInt)

private fun checkReport(differences: List<Int>) = differences.all { abs(it) in 1..3 }
        && (differences.all { it > 0 } || differences.all { it < 0 })
