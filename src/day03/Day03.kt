package day03

fun part1(input: String): Long {
    val regex = """mul\((\d+),(\d+)\)""".toRegex()

    return regex.findAll(input).sumOf { match ->
        val (a, b) = match.destructured
        a.toLong() * b.toLong()
    }
}

fun part2(input: String): Long {
    val regex = """(mul|do|don't)(?:(?<=mul)\((\d+),(\d+)\)|\(\))""".toRegex()

    val (sum, _) = regex.findAll(input).fold(0L to true) { (sum, isEnabled), match ->
        val (command) = match.destructured
        when {
            command == "do" -> sum to true
            command == "don't" -> sum to false
            command == "mul" && isEnabled -> {
                val (_, a, b) = match.destructured
                sum + a.toLong() * b.toLong() to true
            }
            else -> sum to isEnabled
        }
    }
    return sum
}
