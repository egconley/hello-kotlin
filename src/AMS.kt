import java.util.*

fun main(args: Array<String>) {
    println("${if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)<12) "Good morning" else "Good night"}, ${args[0]}!")
    dayOfWeek()
    feedTheFish()
    getFortuneCookie()
}

fun dayOfWeek() {
    println("What day is it today?")
    var day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    when (day) {
        1 -> println("Sunday")
        2 -> println("Monday")
        3 -> println("Tuesday")
        4 -> println("Wednesday")
        5 -> println("Thursday")
        6 -> println("Friday")
        7 -> println("Saturday")
    }
}

fun feedTheFish() {
    val day = randomDay()
    val food = "pellets"
    println("Today is $day and the fish eat $food")
}

fun randomDay(): String {
   val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}

fun getFortuneCookie(): String {
    val fortunes = listOf("You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.", "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune.")
    print("\nEnter your birthday: ")
    val birthday = readLine()?.toIntOrNull() ?: 1
    println("${fortunes[birthday.rem(fortunes.size)]}")
    return fortunes[birthday.rem(fortunes.size)]
}

