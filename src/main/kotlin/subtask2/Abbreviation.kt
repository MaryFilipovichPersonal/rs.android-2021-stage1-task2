package subtask2

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        var isPossible = "NO"
        var i = 0
        for (char in a) {
            if (char.toUpperCase() == b[i]) {
                i++
                if (i == b.length) {
                    isPossible = "YES"
                    break
                }
            }
        }
        return isPossible
    }
}
