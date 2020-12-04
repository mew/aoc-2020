package zone.nora.aoc.days.impl

import zone.nora.aoc.days.AbstractDay

object Day04 : AbstractDay(4) {
    private val requiredFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
    override fun partOne(): Int {
        // holy shit >.>
        /*var valid = 0
        for (i in inputAsList.indices) {
            if (inputAsList[i].isEmpty()) continue
            var s = ""
            for (j in i..(i + 100)) {
                try {
                    if (inputAsList[j].isNotEmpty()) {
                        s += " ${inputAsList[j]}"
                    } else {
                        break
                    }
                } catch (_: IndexOutOfBoundsException) {
                    break
                }
            }
            s += " "
            var flag = true
            for (requiredField in requiredFields) {
                if (!s.contains(requiredField)) {
                    flag = false
                    break
                }
            }
            if (flag) {
                valid++
            }
        }
        return valid*/
        var valid = 0
        inputAsList.forEach {
            var flag = true
            for (requiredField in requiredFields) {
                if (!it.contains("$requiredField:")) {
                    flag = false
                }
            }
            if (flag) {
                valid++
            }
        }
        return valid
    }

    override fun partTwo(): Any {
        var valid = 0
        for (s in inputAsList) {
            var flag = true
            for (requiredField in requiredFields) {
                if (!s.contains("$requiredField:")) {
                    flag = false
                }
            }
            if (flag) {
                val byr = s.getPassportField("byr").toInt()
                if (byr > 2002 || byr < 1920) continue
                val iyr = s.getPassportField("iyr").toInt()
                if (iyr > 2020 || iyr < 2010) continue
                val eyr = s.getPassportField("eyr").toInt()
                if (eyr > 2030 || eyr < 2020) continue
                val hgt = s.getPassportField("hgt")
                when {
                    hgt.endsWith("in") -> {
                        val hgt2 = hgt.replace("in", "").toInt()
                        if (hgt2 > 76 || hgt2 < 59) continue
                    }
                    hgt.endsWith("cm") -> {
                        val hgt2 = hgt.replace("cm", "").toInt()
                        if (hgt2 > 193 || hgt2 < 150) continue
                    }
                    else -> continue
                }
                val hcl = s.getPassportField("hcl")
                if (hcl.startsWith('#')) {
                    try {
                        java.lang.Long.parseLong(hcl.replace("#", ""), 16)
                    } catch (_: NumberFormatException) {
                        continue
                    }
                } else {
                    continue
                }
                when (s.getPassportField("ecl")) {
                    "amb", "blu", "brn", "gry", "grn", "hzl", "oth" -> { }
                    else -> continue
                }
                val pid = s.getPassportField("pid")
                if (pid.length == 9) {
                    try {
                        pid.toLong()
                    } catch (_: Exception) {
                        continue
                    }
                } else {
                    continue
                }
                valid++
            }
        }

        return valid
    }

    private fun String.getPassportField(field: String): String = this.split("$field:")[1].split(" ")[0]
}