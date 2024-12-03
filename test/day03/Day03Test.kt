package day03

import org.junit.jupiter.api.Test
import readInput
import kotlin.test.assertEquals

class Day03Test {
    @Test
    fun `given test input - when part 1 - then result is 161`() {
        val input = readInput("day03/test")
        val result = part1(input)

        assertEquals(161, result)
    }

    @Test
    fun `given test input - when part 2 - then result is 48`() {
        val input = readInput("day03/test_part2")
        val result = part2(input)

        assertEquals(48, result)
    }

    @Test
    fun `given input - when part 1 - then result is 166357705`() {
        val input = readInput("day03/input")
        val result = part1(input)

        assertEquals(166357705, result)
    }

    @Test
    fun `given input - when part 2 - then result is 88811886`() {
        val input = readInput("day03/input")
        val result = part2(input)

        assertEquals(88811886, result)
    }
}