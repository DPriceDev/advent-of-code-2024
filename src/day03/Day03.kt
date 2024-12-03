package day03

fun part1(input: String) = MULTIPLY_REGEX.findAll(input).map { it.groupValues.drop(1) }.sumOf(::multiply)

fun part2(input: String) = DO_DON_T_MULTIPLY_REGEX.findAll(input).fold(initial = 0L to true, ::parseCommand).first

private fun parseCommand(previous: Pair<Long, Boolean>, match: MatchResult): Pair<Long, Boolean> {
    val (sum, isEnabled) = previous
    val command = match.groupValues[1]
    return when {
        command == "don't" -> sum to false
        command == "mul" && isEnabled -> sum + match.groupValues.drop(2).let(::multiply) to true
        else -> sum to (command == "do" || isEnabled)
    }
}

private fun multiply(values: List<String>) = values.map(String::toLong).reduce(Long::times)

private val MULTIPLY_REGEX = """mul\((\d+),(\d+)\)""".toRegex()
private val DO_DON_T_MULTIPLY_REGEX = """(mul|do|don't)(?:(?<=mul)\((\d+),(\d+)\)|\(\))""".toRegex()