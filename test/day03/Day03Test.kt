package day03

import readInput
import kotlin.test.Test
import kotlin.test.assertEquals

class Day03Test {
    @Test
    fun `given test input - when part 1 - then result is 0`() {
        val input = readInput("day03/test")
        val result = part1(input)

        assertEquals(0, result)
    }

    @Test
    fun `given test input - when part 2 - then result is 0`() {
        val input = readInput("day03/test")
        val result = part2(input)

        assertEquals(0, result)
    }

    @Test
    fun `given input - when part 1 - then result is 0`() {
        val input = readInput("day03/input")
        val result = part1(input)

        assertEquals(0, result)
    }

    @Test
    fun `given input - when part 2 - then result is 0`() {
        val input = readInput("day03/input")
        val result = part2(input)

        assertEquals(0, result)
    }
}