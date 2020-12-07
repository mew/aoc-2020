package zone.nora.aoc.days.impl

import zone.nora.aoc.days.AbstractDay
import java.util.concurrent.CopyOnWriteArrayList

object Day07 : AbstractDay(7) {
    override fun partOne(): Int {
        fun find(bagColour: String): List<String> {
            val colours = CopyOnWriteArrayList<String>()
            for (s in inputAsList) {
                if (s.contains(bagColour) && !s.startsWith(bagColour)) {
                    val split = s.split(' ')
                    colours.addIfAbsent("${split[0]} ${split[1]}")
                }
            }
            for (colour in colours) {
                colours.addAllAbsent(find(colour))
            }
            return colours
        }
        return find("shiny gold").size
    }

    override fun partTwo(): Int {
        fun find(bagColour: String): List<String> {
            val colours = CopyOnWriteArrayList<String>()
            for (s in inputAsList) {
                if (s.startsWith(bagColour)) {
                    val s2 = s.split("contain ")[1]
                    if (s2.contains(", ")) {
                        s2.split(", ").forEach {
                            val split = it.split(" ")
                            for (i in 1..split[0].toInt()) {
                                colours.add("${split[1]} ${split[2]}")
                            }
                        }
                    } else if (!s2.contains("no other")) {
                        val split = s2.split(' ')
                        for (i in 1..split[0].toInt()) {
                            colours.add("${split[1]} ${split[2]}")
                        }
                    }
                }
            }
            for (colour in colours) {
                colours.addAll(find(colour))
            }
            return colours
        }
        return find("shiny gold").size
    }
}