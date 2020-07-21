import java.lang.Math.random
import java.util.*

fun main(args: Array<String>) {
    println("${if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < 12) "Good morning" else "Good night"}, ${args[0]}!")
    dayOfWeek()
    feedTheFish()
//    val bday = getBiirthday()
//    getFortuneCookie(bday)
    println("test 1: " + canAddFish(10.0, listOf(3,3,3)))
    println("test 2: " + canAddFish(8.0, listOf(2,2,2), hasDecorations = false))
    println("test 3: " + canAddFish(9.0, listOf(1,1,3), 3))
    println("test 4: " + canAddFish(10.0, listOf(), 7, true))
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
    val food = fishFood(day)
    shouldChangeWater(day=day)
    println("Today is $day and the fish eat $food")
}

fun randomDay() : String {
   val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}

fun fishFood(day : String) : String {
    // verbose way
//    var food = "fasting"
//
//    when (day) {
//        "Monday" -> food = "flakes"
//        "Tuesday" -> food = "pellets"
//        "Wednesday" -> food = "redworms"
//        "Thursday" -> food = "granules"
//        "Friday" -> food = "mosquitos"
//        "Saturday" -> food = "lettuce"
//        "Sunday" -> food = "plankton"
//    }
//    return food

    // clean way
    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitos"
        "Saturday" -> "lettuce"
        "Sunday" ->  "plankton"
        else -> "fasting"
    }
}

// default values - best practice to list arguments with default values last
// function call can be default value
// default parameters are evaluated at call time, so be wary of using expensive default functions here,
// like reading files, or something that takes a lot of memory
fun shouldChangeWater(
        day: String,
        temperature: Int=22,
        dirty: Int=getDirtySensorReading()) : Boolean {

    // before refactor
//    val isTooHot = temperature > 30
//    val isDirty = dirty > 30
//    val isSunday = day == "Sunday"
//
//    return when {
//        isTooHot -> true
//        isDirty -> true
//        isSunday -> true
//        else -> false
//    }

    // after refactor
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

// Boolean return value implied
fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"

// default return values for functions
fun getDirtySensorReading() = 20

fun canAddFish(tankSize: Double,
               currentFish: List<Int>,
               fishSize: Int=2,
               hasDecorations: Boolean=true) : Boolean {
    // alternate return statement
//    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
    return if (hasDecorations) {
        tankSize*0.8 - currentFish.sum() >= fishSize
    } else {
        tankSize - currentFish.sum()  >= fishSize
    }
}


fun getFortuneCookie(bday : Int) : String {
    val fortunes = listOf("You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.", "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune.")
    val index = when (bday) {
        in 1..7 -> 4
        28, 31 -> 2
        else -> bday.rem(fortunes.size)
    }
    println("${fortunes[index]}")
    return fortunes[index]
}

fun getBiirthday() : Int {
    print("\nEnter your birthday: ")
    return readLine()?.toIntOrNull() ?: 1
}

