package aquarium

fun main (args: Array<String>) {
    buildAquarium()
}

fun buildAquarium() {
    // in Java: Aquarium myAquarium  = new Aquarium();
    val myAquarium = Aquarium()

    // getters happen implicitly
    println("Length: ${myAquarium.length} " +
            "Width: ${myAquarium.width} " +
            "Height: ${myAquarium.height} ")

    // setters happen implicitly
    myAquarium.height = 80

    println("Height: ${myAquarium.height}  cm")
    println("Volume: ${myAquarium.volume}  liters")

    val smallAquarium = Aquarium(length = 20, width = 15, height = 30)
    val anotherAquarium = Aquarium(numberOfFish = 6)

    println("Other aquarium: ${anotherAquarium.volume} liters with " +
            "length ${anotherAquarium.length} " +
            "width: ${anotherAquarium.width} " +
            "height: ${anotherAquarium.height} ")
}