package aquarium

import kotlin.math.PI

//  by default classes are not subclassable, you have to mark them as open
                // this is the default constructor for the class
open class Aquarium (var length: Int = 100, var width: Int = 20, var height: Int = 40) {

    // (1) FROM this:
//    fun volume(): Int {
//        return width * height * length / 1000
//    }

    // (2) TO this as one line:
//    fun volume() = width * height * length / 1000

    // (3) TO this: volume as a property
    // override default getter to calculate value of volume property
    // open - allows overriding by subclasses
    open var volume : Int
        get() = width * height * length / 1000
        // at least one of the other parameters has to change when you change the volume,
        // so we're arbitrarily setting a new height as well based on the new volume
        set(value) {height = (value * 1000) / (width * length)}

    open var water = volume * 0.9

    // overriding the default constructor
                                // this() is a call to the default constructor
    constructor(numberOfFish: Int): this() {
        val water:Int = numberOfFish * 2000 // cm3
        val tank:Double = water + water * 0.1
        height = (tank / (length * width)).toInt()
    }
}

// TowerTank inherits from Aquarium
class TowerTank(): Aquarium() {
    override var water = volume * 0.8
    override var volume: Int
        get() = (width * height * length / 1000 * PI).toInt()
        set(value) {
            height = (value * 1000) / (width * length)
        }
}