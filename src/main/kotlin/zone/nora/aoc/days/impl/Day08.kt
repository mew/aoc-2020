package zone.nora.aoc.days.impl

import zone.nora.aoc.days.AbstractDay
import zone.nora.aoc.util.AdventError

object Day08 : AbstractDay(8) {
    override fun partOne(): Any {
        val gc = ArrayList<Int>()
        var accumulator = 0
        fun parseInstruction(instruction: Int) {
            if (gc.contains(instruction)) {
                return
            }
            gc.add(instruction)
            val split = inputAsList[instruction].split(' ')
            when (split[0]) {
                "acc" -> {
                    accumulator += split[1].replace("+", "").toInt()
                    parseInstruction(instruction + 1)
                }
                "jmp" -> parseInstruction(instruction + split[1].replace("+", "").toInt())

                "nop" -> parseInstruction(instruction + 1)
            }
        }
        parseInstruction(0)
        return accumulator
    }

    override fun partTwo(): Any {
        for (i in inputAsList.indices) {
            if (inputAsList[i].startsWith("acc")) {
                continue
            }
            var accumulator = 0
            val gc = ArrayList<Int>()
            fun parseInstruction(instruction: Int): Int {
                if (instruction == inputAsList.size - 1) {
                    return accumulator
                }
                if (gc.contains(instruction)) {
                    return 1010101010
                }
                gc.add(instruction)
                val split = inputAsList[instruction].split(' ')
                var inst = split[0]
                if (instruction == i) {
                    inst = if (inst == "nop") "jmp" else "nop"
                }
                return when (inst) {
                    "acc" -> {
                        accumulator += split[1].replace("+", "").toInt()
                        parseInstruction(instruction + 1)
                    }
                    "jmp" -> parseInstruction(instruction + split[1].replace("+", "").toInt())
                    "nop" -> parseInstruction(instruction + 1)
                    else -> 1010101010
                }
            }

            if (parseInstruction(0) != 1010101010) {
                return accumulator
            }
        }
        return AdventError.unexpectedlyReachedEnd()
    }
}