package day02

import org.junit.jupiter.api.Test
import readLines
import kotlin.test.assertEquals

class Day02Test {
    @Test
    fun `given test input - when part 1 - then result is 2`() {
        val input = readLines("day02/test")
        val result = part1(input)

        assertEquals(2, result)
    }

    @Test
    fun `given test input - when part 2 - then result is 4`() {
        val input = readLines("day02/test")
        val result = part2(input)

        assertEquals(4, result)
    }

    @Test
    fun `given input - when part 1 - then result is 660`() {
        val input = readLines("day02/input")
        val result = part1(input)

        assertEquals(660, result)
    }

    @Test
    fun `given input - when part 2 - then result is 689`() {
        val input = readLines("day02/input")
        val result = part2(input)

        assertEquals(689, result)
    }
}