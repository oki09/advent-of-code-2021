package day2

import java.io.File

fun main() {
    val lines = File("inputs/day2/input.txt").readLines()
    val depthLines = lines.filter { it.contains("down") || it.contains("up") }
    val forwardLines = lines.filter { it.contains("forward") }
    val depth: Int = calcDepth(depthLines)
    val horizontal: Int = calcHorizontalPos(forwardLines)
    println("Final depth: $depth; final horizontal pos: $horizontal; end result: ${depth * horizontal}")
    println("Final result with aim considered: ${calcWithAim(lines)}")
}

fun calcDepth(lines: List<String>): Int =
    lines.sumOf {
        val (command, x) = it.split(" ")
        when (command) {
            "down" -> x.toInt()
            "up" -> -x.toInt()
            else -> 0
        }
    }

fun calcHorizontalPos(lines: List<String>): Int = lines.sumOf { it.split(" ")[1].toInt() }

fun calcWithAim(lines: List<String>): Int {
    var aim = 0
    var depth = 0
    var forward = 0

    for(line in lines) {
        val (command, tmp) = line.split(" ")
        val x = tmp.toInt()
        when (command) {
            "forward" -> {
                forward += x
                depth += (aim * x)
            }
            "down" -> aim += x
            "up" -> aim -= x
        }
    }
    println("Horizontal with aim considered: $forward")
    println("Depth with aim considered: $depth")
    return depth * forward
}