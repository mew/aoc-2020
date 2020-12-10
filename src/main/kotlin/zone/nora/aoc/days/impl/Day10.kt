package zone.nora.aoc.days.impl

import zone.nora.aoc.days.AbstractDay

object Day10 : AbstractDay(10) {
    override fun partOne(): Int {
        val sorted = inputAsList.map { it.toInt() }.sorted()
        var diffOfOne = 1
        var diffOfThree = 1
        for (i in sorted.indices) {
            if (i == sorted.lastIndex) {
                continue
            }
            when (sorted[i + 1] - sorted[i]) {
                1 -> diffOfOne++
                3 -> diffOfThree++
            }
        }
        return diffOfOne * diffOfThree
    }

    override fun partTwo(): Long {
        val sorted = inputAsList.map { it.toInt() }.asSequence().sorted()
        val x = mutableMapOf<Int, Long>()
        for (i in 1..3) {
            x[i] = 1
        }
        for (i in sorted) {
            x[i] = x.getOrDefault(i - 3, 0) + x.getOrDefault(i - 2, 0) + x.getOrDefault(i - 1, 0) + x.getOrDefault(i, 0)
        }
        return x[sorted.last()] ?: throw RuntimeException()
    }
}