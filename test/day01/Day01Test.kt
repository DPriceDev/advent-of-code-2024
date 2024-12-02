package day01

import readInput
import kotlin.test.Test
import kotlin.test.assertEquals

class Day01Test {
    @Test
    fun `given test input - when part 1 - then result is 11`() {
        val input = readInput("day01/test")
        val result = part1(input)

        assertEquals(11, result)
    }

    @Test
    fun `given test input - when part 2 - then result is 31`() {
        val input = readInput("day01/test")
        val result = part2(input)

        assertEquals(31, result)
    }

    @Test
    fun `given input - when part 1 - then result is 1388114`() {
        val input = readInput("day01/input")
        val result = part1(input)

        assertEquals(1388114, result)
    }

    @Test
    fun `given input - when part 1 - then result is 23529853`() {
        val input = readInput("day01/input")
        val result = part2(input)

        assertEquals(23529853, result)
    }
}