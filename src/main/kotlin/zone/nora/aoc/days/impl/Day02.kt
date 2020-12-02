package zone.nora.aoc.days.impl

import zone.nora.aoc.days.AbstractDay

object Day02 : AbstractDay(2) {
    override fun partOne(): Int {
        var valid = 0
        for (inputLine in inputAsList) {
            val i = inputLine.split(' ')
            val x = i[0].split('-')
            val restriction = x[0].toInt() to x[1].toInt()
            val char = i[1].first()
            val num = i[2].toCharArray().filter { it == char }.size
            if (num >= restriction.first && num <= restriction.second) valid++
        }
        return valid
    }

    override fun partTwo(): Any {
        var valid = 0
        for (inputLine in inputAsList) {
            val i = inputLine.split(' ')
            val x = i[0].split('-')
            val restriction = x[0].toInt() to x[1].toInt()
            val char = i[1].first()
            val pw = i[2].toCharArray()

            fun x(num: Int): Char? = try {
                pw[num]
            } catch (e: ArrayIndexOutOfBoundsException) {
                null
            }

            //println("${pw.size} ${restriction.first} ${restriction.second}")
            var b = false
            if ((x(restriction.first-1) == char) xor (x(restriction.second-1) == char)) {
                b = true
                valid++
            }
            println("$inputLine: $b")
        }
        return valid
    }
}