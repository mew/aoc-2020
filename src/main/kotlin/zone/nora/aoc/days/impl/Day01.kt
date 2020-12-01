package zone.nora.aoc.days.impl

import zone.nora.aoc.days.AbstractDay
import zone.nora.aoc.util.AdventError

object Day01 : AbstractDay(1) {
    override fun partOne(): Any {
        for (i in inputAsList) {
            for (j in inputAsList) {
                if (i.toInt() + j.toInt() == 2020) {
                    println("$i * $j")
                    return i.toInt() * j.toInt()
                }
            }
        }
        return AdventError.unexpectedlyReachedEnd()
    }

    override fun partTwo(): Any {
        for (i in inputAsList) {
            for (j in inputAsList) {
                for (k in inputAsList) {
                    if (i.toInt() + j.toInt() + k.toInt() == 2020) {
                        println("$i * $j * $k")
                        return i.toInt() * j.toInt() * k.toInt()
                    }
                }
            }
        }
        return AdventError.unexpectedlyReachedEnd()
    }
}