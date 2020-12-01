package zone.nora.aoc.util

import java.io.File

object InputUtil {
    fun getInputAsList(day: Int): List<String> = inputFile(day).readLines(Charsets.UTF_8)

    fun getInputAsString(day: Int) = inputFile(day).readText()

    private fun inputFile(day: Int): File =
        File(javaClass.classLoader.getResource("day${if (day < 10) "0$day" else day}.txt")!!.toURI())
}