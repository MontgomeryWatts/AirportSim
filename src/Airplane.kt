class Airplane(val timeToFinish: Int, val maxTimeAirborne: Int, val isLanding: Boolean, val timeArrived: Int){
    constructor() : this(0, 0, false, 0) //Just used for testing



    companion object numPlanes{
        var id = 0
    }
    val id = numPlanes.id++

    init {
        println(if (isLanding) "Plane #$id has arrived for landing." else "Plane #$id has arrived for take off.")
    }

    var nextPlane : Airplane? = null //Planes will be put into a linked list implementation of a queue

    fun crash() = println("Plane #$id is crashing!")
    fun begin() = if (isLanding) println("Plane #$id is starting to land.") else println("Plane #$id is starting to take off.")
    fun finished() = if (isLanding) println("Plane #$id finished landing.") else println("Plane #$id finished taking off.")
}