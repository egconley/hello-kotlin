package aquarium

class Aquarium {
    var width: Int = 20
    var height: Int = 40
    var length: Int = 100


    // (1) FROM this:
//    fun volume(): Int {
//        return width * height * length / 1000
//    }

    // (2) TO this as one line:
//    fun volume() = width * height * length / 1000

    // (3) TO this: volume as a property
    // override default getter to calculate value of volume property
    var volume : Int
        get() = width * height * length / 1000
        // at least one of the other parameters has to change when you change the volume,
        // so we're arbitrarily setting a new height as well based on the new volume
        set(value) {height = (value * 1000) / (width * length)}
}