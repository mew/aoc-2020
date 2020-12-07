package zone.nora.aoc.test

import org.junit.Test
import zone.nora.aoc.days.impl.Day07

class Test {
    private val currentDay = Day07

    @Test
    fun testFirstPart() {
        breakline()
        println("Day ${currentDay.day}, Part 1:")
        put(currentDay.partOne())
        breakline()
    }

    @Test
    fun testSecondPart() {
        breakline()
        println("Day ${currentDay.day}, Part 2:")
        put(currentDay.partTwo())
        breakline()
    }

    private fun put(answer: Any) {
        if (answer !is Unit) {
            println(answer)
        }
    }

    private fun breakline() = println("-------------------------------")
}