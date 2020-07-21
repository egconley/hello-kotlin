package aquarium

// exploring composition
fun main(args: Array<String>) {
    delegate()
}

fun delegate() {
    val pleco = Plecostomus()
    println("Fish has color ${pleco.color}")
    pleco.eat()
}

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

// we can remove inheritance from AquariumFish because we get all the functionality from the interfaces
                                                                // interface delegation
class Plecostomus(fishColor: FishColor = GoldColor): FishAction by PrintingFishAction("a lot of algae"), FishColor by fishColor // {

    // before implementing interface delegation
//    override fun eat() {
//        println("eat algae")
//    }
//
//    override val color: String
//        get() = "gold"
//}

// interface delegation - we need an object that knows how to provide a fish color
// using the object keyword still declares a class, but we don't need multiple instances of "gold", so this lets us only declare one
// this is how to implement the singleton pattern in kotlin
object GoldColor: FishColor {
    override val color = "gold"
}

object RedColor: FishColor {
    override val color = "gold"
}

class PrintingFishAction(val food: String): FishAction {
    override fun eat() {
        println(food)
    }
}