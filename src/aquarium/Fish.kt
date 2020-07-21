package aquarium

class Fish (val friendly: Boolean = true, volumeNeeded: Int) {
    // good kotlin class only define one constructor with default values for optional parameters and init blocks
    val size: Int

    // init block: use the way you would use a constructor body
    // can be anywhere in the class, always run before any secondary constructors
    // no need to explicity call them, they are called, in order, as part of the constructor
    init {
        println("first init block")
    }

    // secondary constructors must contain a call to the primary constructor
    constructor() : this(true, 9) {
        println("running secondary constructor")
    }

    init {
        if (friendly) {
            size = volumeNeeded
        } else {
            size = volumeNeeded * 2
        }
    }

    init {
        println("constructed fish of size $volumeNeeded final size ${this.size}")
    }

    init {
        println("last init block")
    }
}

// if you feel like you want to make a second constructor, consider making a helper mmethod instead
// keeps classes simple and provides a clean api
fun makeDefaultFish() = Fish(true, 50)

fun fishExample() {
    val fish = Fish(true, 20)
    // volumen isn't a property, so you have to call size instead
    println("Is the fish friendly? ${fish.friendly}. It needs volume ${fish.size}")
}