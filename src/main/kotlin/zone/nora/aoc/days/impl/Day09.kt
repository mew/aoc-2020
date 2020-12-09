package zone.nora.aoc.days.impl

import zone.nora.aoc.days.AbstractDay
import zone.nora.aoc.util.AdventError

object Day09 : AbstractDay(9) {
    override fun partOne(): Long {
        x@for (i in inputAsList.indices) {
            if (i < 25) {
                continue@x
            }
            val num = inputAsList[i].toLong()
            for (j in (i - 25)..i) {
                for (k in 0..24) {
                    if (num == inputAsList[j].toLong() + inputAsList[j + k].toLong()) {
                        continue@x
                    }
                }
            }
            return num
        }
        return 0L
    }

    override fun partTwo(): Any {
        val target = partOne()
        for (i in inputAsList.indices) {
            val sequence = ArrayList<Long>()
            sequence.add(inputAsList[i].toLong())
            var j = i + 1
            while (sequence.sum() < target) {
                sequence.add(inputAsList[j].toLong())
                j++
            }
            if (sequence.sum() == target) {
                sequence.sort()
                return sequence.first() + sequence.last()
            }
        }
        return AdventError.unexpectedlyReachedEnd()
    }
}