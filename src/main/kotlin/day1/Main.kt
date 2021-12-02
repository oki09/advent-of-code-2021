import java.io.File

fun main() {
    val lines = File("inputs/day1/input.txt").readLines()
    println(getIncreaseCount(lines))
    println(getMeasurementWindowSumIncreases(lines))
}

fun getIncreaseCount(lines: List<String>): Int {
    var increaseCount = 0
    var prevDepth = lines[0].toInt()

    // start at second value
    for (idx in 1 until lines.size) {
        val curDepth = lines[idx].toInt()
        if (curDepth > prevDepth) increaseCount++
        prevDepth = curDepth
    }

    return increaseCount
}

fun getMeasurementWindowSumIncreases(lines: List<String>): Int {
    var increaseCount = 0
    val measurementWindowLength = 3

    var prevSum = (0 until measurementWindowLength).map { lines[it].toInt() }.toIntArray().sum()

    for (idx in 1 until lines.size) {
        val untilIdx = idx + measurementWindowLength
        if(untilIdx <= lines.size) {
            val curSum = (idx until untilIdx).map { lines[it].toInt() }.toIntArray().sum()
            if (curSum > prevSum) increaseCount++
            prevSum = curSum
        }
    }
    return increaseCount
}