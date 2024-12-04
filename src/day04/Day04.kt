package day04

import kotlin.math.abs

fun part1(input: List<String>) = with(input.map(String::toList)) {
    val rows = asHorizontalSequence() + asVerticalSequence() + asDiagonalSequence() + asReversed().asDiagonalSequence()
    rows.sumOf { it.countOccurrences() }
}

fun part2(input: List<String>) = with(input.toCoordinateGrid()) {
    val rows = asDiagonalSequence() + asReversed().asDiagonalSequence()
    rows.flatMap { it.findCenterPoints() }
        .groupBy { it }
        .count { (_, coords) -> coords.size > 1 }
}

private fun List<String>.toCoordinateGrid() = mapIndexed { row, line ->
    line.mapIndexed { column, letter -> (row to column) to letter }
}

private fun Sequence<Char>.countOccurrences() = windowed(4)
    .map { it.joinToString("") }
    .count { it == "XMAS" || it == "SAMX" }

private fun Sequence<Pair<Pair<Int, Int>, Char>>.findCenterPoints() = windowed(3)
    .mapNotNull { row ->
        val word = row.map { it.second }.joinToString("")
        if (word == "MAS" || word == "SAM") row[1].first else null
    }

private fun <T> List<List<T>>.asHorizontalSequence() = asSequence().map(List<T>::asSequence)

private fun <T> List<List<T>>.asVerticalSequence() = sequence {
    first().indices.forEach { column ->
        val columnSequence = sequence {
            indices.forEach { row -> yield(this@asVerticalSequence[row][column]) }
        }
        yield(columnSequence)
    }
}

private fun <T> List<List<T>>.asDiagonalSequence() = sequence {
    val maxRows = size * 2 - 1
    val maxColumns = first().size - 1

    (0 until maxRows).forEach { row ->
        val sequence = sequence {
            val halfPoint = maxRows / 2 + 1
            val columns = halfPoint - abs(halfPoint - (row + 1))

            (0 until columns).forEach { column ->
                val rowIndex = row.coerceAtMost(size - 1) - column
                val columnIndex = (row - maxColumns).coerceAtLeast(0) + column
                val item = this@asDiagonalSequence[rowIndex][columnIndex]
                yield(item)
            }
        }
        yield(sequence)
    }
}