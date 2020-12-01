package zone.nora.aoc.days

import zone.nora.aoc.util.InputUtil

abstract class AbstractDay(val day: Int) {
    protected val inputAsList: List<String> = InputUtil.getInputAsList(day)
    protected val inputAsString: String = InputUtil.getInputAsString(day)

    abstract fun partOne(): Any

    abstract fun partTwo(): Any
}