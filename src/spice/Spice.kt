package spice

import aquarium.AquariumFish

abstract class Spice (val name: String, var spiciness: String = "mild", color: SpiceColor) : SpiceColor by color {
    val heat: Int
        get() {
            return when (spiciness) {
                "mild" -> 1
                "medium" -> 3
                "spicy" -> 5
                "very spicy" -> 7
                "extremely spicy" -> 10
                else -> 0
            }
        }

    abstract fun prepareSpice()

    // now that the class is abstract, we cannot make an instance of it
//    val spices1 = listOf(
//            Spice("curry", "mild"),
//            Spice("pepper", "medium"),
//            Spice("cayenne", "spicy"),
//            Spice("ginger", "mild"),
//            Spice("red curry", "medium"),
//            Spice("green curry", "mild"),
//            Spice("hot pepper", "extremely spicy")
//    )

    init {
//        println(spices1)
    }

//    val spice = Spice("cayenne", spiciness = "spicy")
//    val spicelist = spices1.filter {it.heat < 5}

    // helper function that makes salt, since it's common
//    fun makesSalt() = Spice("Salt")
}

class Curry(name: String, spiciness: String, color: SpiceColor = YellowColor) : Spice(name), Grinder, SpiceColor by color {

    override fun grind() {
    }

    override fun prepareSpice() {
        grind()
    }

}

interface Grinder {
    fun grind()
}

interface SpiceColor {
    val color: String
}

object YellowColor : SpiceColor {
    override val color = "yellow"
}

fun delegate() {
    val curry = Curry("yellow", "medium")
    curry.grind()
}

