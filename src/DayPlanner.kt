import java.util.*

fun main(args: Array<String>) {

    println(whatShouldIDoToday("happy", "sunny"))
    println(whatShouldIDoToday("sad"))
    print("How do you feel?")
    // !! avoids type mismatch - with the !! the type is String, not String?
    println(whatShouldIDoToday(readLine()!!))
}

fun isHappySunny(mood: String, weather: String) = mood == "happy" && weather == "Sunny"
fun isSadRainyCold(mood: String, weather: String, temperature: Int) = mood == "sad" && weather == "rainy" && temperature == 0
fun isVeryHot(temperature: Int) = temperature > 35

fun whatShouldIDoToday(mood: String, weather: String="sunny", temperature: Int=24) : String {
    return when {
        isHappySunny(mood, weather) -> "go for a walk"
        isSadRainyCold(mood, weather, temperature) -> "stay in bed"
        isVeryHot(temperature)-> "go swimming"
        else -> "Stay home and read."
    }
}

// filters
fun filters() {
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")
// Sorting curries by string length
    spices.filter { it.contains("curry") }.sortedBy { it.length }
// Filtering by those that start with 'c' and end with 'e'
    spices.filter { it.startsWith('c') }.filter { it.endsWith('e') }
    // Filtering the first 3 items by 'c'
    spices.take(3).filter{it.startsWith('c')}
}

// lambdas
val random1 = Math.random() // only generates a random number on compile time
val random2 = { Math.random() } // generates a random number every time random2 is accessed because the lambda is executed every time the variable is referenced

// practice lambdas
// 1. Create a lambda and assign it to rollDice, which returns a dice roll (number between 1 and 12).
//val rollDice = { Random().nextInt(12) + 1}
// 2. Extend the lambda to take an argument indicating the number of sides of the dice used for the roll.
val rollDice = { sides: Int ->
    Random().nextInt(sides) + 1
}
// 4. If you haven't done so, fix the lambda to return 0 if the number of sides passed in is 0.
val rollDice0 = { sides: Int ->
    if (sides == 0) 0
    else Random().nextInt(sides) + 1
}
// 5. Create a new variable, rollDice2, for this same lambda using the function type notation.
val rollDice2: (Int) -> Int = { sides ->
    if (sides == 0) 0
    else Random().nextInt(sides) + 1
}
// Q: Why would you want to use the function type notation instead of just the lambda?
// A: Function type notation is more readable, which reduces errors, clearly showing the what type is passed in and what type is returned.
// Create a function gamePlay() that takes a roll of the dice as an argument and prints it out.
//gamePlay(rollDice2(4))
// Pass your rollDice2 function as an argument to gamePlay() to generate a dice roll every time gamePlay() is called.
fun gamePlay(diceRoll: Int){
    // do something with the dice roll
    println(diceRoll)
}
