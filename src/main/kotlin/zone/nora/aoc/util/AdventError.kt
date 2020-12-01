package zone.nora.aoc.util

data class AdventError(val message: String) {
    companion object {
        fun unexpectedlyReachedEnd(): AdventError = AdventError("Unexpectedly reached end of code.")
    }
}