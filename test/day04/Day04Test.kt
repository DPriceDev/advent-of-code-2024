package day04

import org.junit.jupiter.api.Test
import readLines
import kotlin.test.assertEquals

class Day04Test {
    @Test
    fun `given test input - when part 1 - then result is 18`() {
        val input = readLines("day04/test")
        val result = part1(input)

        assertEquals(18, result)
    }

    @Test
    fun `given test input - when part 2 - then result is 9`() {
        val input = readLines("day04/test")
        val result = part2(input)

        assertEquals(9, result)
    }

    @Test
    fun `given input - when part 1 - then result is 2483`() {
        val input = readLines("day04/input")
        val result = part1(input)

        assertEquals(2483, result)
    }

    @Test
    fun `given input - when part 2 - then result is 1925`() {
        val input = readLines("day04/input")
        val result = part2(input)

        assertEquals(1925, result)
    }
}