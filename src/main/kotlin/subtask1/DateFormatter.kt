package subtask1

import java.util.*

class DateFormatter {

    private val monthArray: Array<String> = arrayOf(
        "января",
        "февраля",
        "марта",
        "апреля",
        "мая",
        "июня",
        "июля",
        "августа",
        "сентября",
        "октября",
        "ноября",
        "декабря"
    )

    private val daysWeekArray: Array<String> = arrayOf(
        "",
        "воскресенье",
        "понедельник",
        "вторник",
        "среда",
        "четверг",
        "пятница",
        "суббота"
    )

    fun toTextDay(day: String, month: String, year: String): String {
        val calendar: Calendar = GregorianCalendar(year.toInt(), month.toInt()-1, day.toInt())
        calendar.isLenient = false
        try {
            calendar.time
        } catch (e: Exception) {
            return "Такого дня не существует"
        }
        return "${calendar.get(Calendar.DAY_OF_MONTH)} ${monthArray[calendar.get(Calendar.MONTH)]}, ${daysWeekArray[calendar.get(Calendar.DAY_OF_WEEK)]}"
    }
}
