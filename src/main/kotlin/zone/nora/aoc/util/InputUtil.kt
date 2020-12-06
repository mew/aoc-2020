package zone.nora.aoc.util

import java.io.File

object InputUtil {
    fun getInputAsList(day: Int): List<String> = inputFile(day).readLines(Charsets.UTF_8)

    fun getInputAsString(day: Int): String = inputFile(day).readText()

    fun convertSplitInput(input: String): List<String> {
        val list = ArrayList<String>()
        input.split("\n\n").forEach {
            list.add(it.replace('\n', ' '))
        }
        return list
    }

    private fun inputFile(day: Int): File =
        File(javaClass.classLoader.getResource("day${if (day < 10) "0$day" else day}.txt")!!.toURI())
}