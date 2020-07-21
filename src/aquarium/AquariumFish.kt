package aquarium
// note: abstract classes can have constructors, interfaces cannot
        // both abstract classes and interfaces can contain implementations of methods
        // with interfaces, they're called default implementations
// when to use an interface: if you have a lot of methods and 1 or 2 default implementations
// when you use an abstract class: anytime you can't complete a class (ex. a good default value doesn't exist)

// a better tool (in kotlin) than abstract classes: interface delegation
// interface delegation lets you add features to a class via composition
// composition is when you USE an instance of another class, as opposed to INHERITING from it
// instead of requiring the caller's subclass a giant abstract class, give them a small interface,
// and let them delegate those interfaces to an object (see Inheritance.kt)

abstract class AquariumFish {
    abstract val color: String
}

class Shark: AquariumFish(), FishAction {
    override val color = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }
}

// alternate code using composition in Inheritance.kt
//class Plecostomus: AquariumFish(), FishAction {
//    override val color = "gold"
//    override fun eat() {
//        println("munch on algae")
//    }
//}

//interface FishAction {
//    fun eat()
//}