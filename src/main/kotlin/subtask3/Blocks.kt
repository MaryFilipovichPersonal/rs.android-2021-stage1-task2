package subtask3

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        return when (blockB) {
            String::class -> concat(blockA)
            Int::class -> sum(blockA)
            LocalDate::class -> nearestLastDate(blockA).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            else -> Any()
        }
    }

    private fun concat(blockA: Array<*>): String {
        var result = ""
        for (element in blockA)
            if (element!! is String)
                result += element as String
        return result
    }

    private fun sum(blockA: Array<*>): Int {
        var result = 0
        for (element in blockA)
            if (element!! is Int)
                result += (element as? Int ?: 0)

        return result
    }

    private fun nearestLastDate(blockA: Array<*>): LocalDate {
        var result: LocalDate = LocalDate.MIN
        for (date in blockA)
            if (date!! is LocalDate) {
                val localDate = date as LocalDate
                result =
                    if (localDate > result && localDate <= LocalDate.now())
                        localDate
                    else result
            }
        return result
    }

}
