package zone.nora.aoc.days.impl

import zone.nora.aoc.days.AbstractDay
import zone.nora.aoc.util.AdventError

object Day05 : AbstractDay(5) {
    override fun partOne(): Any {
        var highest = 0
        inputAsList.forEach {
            val d = decodeSeat(it)
            val x = d.first * 8 + d.second
            if (x > highest) {
                highest = x
            }
        }
        return highest
    }

    override fun partTwo(): Any {
        val ids = ArrayList<Int>()
        inputAsList.forEach {
            val d = decodeSeat(it)
            ids.add(d.first * 8 + d.second)
        }
        for (id in ids) {
            if (!ids.contains(id - 1)) {
                if (ids.contains(id - 2)) {
                    return id - 1
                }
            }
        }
        return AdventError.unexpectedlyReachedEnd()
    }

    private fun decodeSeat(seat: String): Pair<Int, Int> {
        var r = 0..127
        for (i in 0..6) {
            val mid = ((r.last + 1 - r.first) / 2) + r.first
            r = if (seat[i] == 'F') r.first until mid else mid..r.last
        }
        var c = 0..7
        for (i in 7..9) {
            val mid = ((c.last + 1 - c.first) / 2) + c.first
            c = if (seat[i] == 'L') c.first until mid else mid..c.last
        }
        return r.first to c.first
    }
}