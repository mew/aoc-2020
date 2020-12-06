package zone.nora.aoc.days.impl

import zone.nora.aoc.days.AbstractDay
import zone.nora.aoc.util.InputUtil

object Day06 : AbstractDay(6) {
    override fun partOne(): Any {
        val input = InputUtil.convertSplitInput(inputAsString)
        var unique = 0
        input.forEach {
            val chars = ArrayList<Char>()
            it.replace(" ", "").toCharArray().forEach { c ->
                if (!chars.contains(c)) {
                    chars.add(c)
                }
            }
            unique += chars.size
        }
        return unique
    }

    override fun partTwo(): Any {
        val input = InputUtil.convertSplitInput(inputAsString)
        var x = 0
        input.forEach {
            val s = it.replace(" ", "")
            var i = 0
            "abcdefghijklmnopqrstuvwxyz".toCharArray().forEach { c ->
                if (s.toCharArray().filter { char -> char == c }.size == it.split(' ').size) {
                    i++
                }
            }
            x += i
        }
        return x
    }
}