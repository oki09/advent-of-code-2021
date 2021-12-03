package day3

import java.io.File

fun main() {
    val lines = File("inputs/day3/input.txt").readLines()

    // get total number of bits
    val totalBits = lines[0].length
    var gammaRateString = ""
    var epsilonRateString = ""
    for (i in 0 until totalBits) {
        val map = lines.groupingBy { it[i] }.eachCount()
        val mostCommonBit = map.maxByOrNull { it.value }?.key ?: ' '
        val leastCommonBit = map.minByOrNull { it.value }?.key ?: ' '
        gammaRateString += mostCommonBit
        epsilonRateString += leastCommonBit
    }
    val gammaRate = Integer.parseInt(gammaRateString, 2)
    val epsilonRate = Integer.parseInt(epsilonRateString, 2)
    println("Gamma rate $gammaRate, epsilon rate $epsilonRate")
    println("Result is ${gammaRate * epsilonRate}")
}