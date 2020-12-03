package zone.nora.aoc.days.impl

import zone.nora.aoc.days.AbstractDay

object Day03 : AbstractDay(3) {
    override fun partOne(): Any {
        var pos = 0
        var count = 0
        inputAsList.forEach {
            if (it.repeat(100).toCharArray()[pos] == '#') {
                count++
            }
            pos += 3
        }
        return count
    }

    override fun partTwo(): Any {
        val slopes = listOf(1 to 1, 3 to 1, 5 to 1, 7 to 1, 1 to 2)
        var final = 1L
        slopes.forEach {
            var xPos = 0
            var yPos = 0
            var count = 0
            for (i in inputAsList.indices) {
                val line = try {
                    inputAsList[yPos].repeat(100)
                } catch (_: IndexOutOfBoundsException) {
                    continue
                }
                if (line.toCharArray()[xPos] == '#') {
                    count++
                }
                xPos += it.first
                yPos += it.second
            }
            final *= count
        }
        return final
    }
}