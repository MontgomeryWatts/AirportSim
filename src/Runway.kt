class Runway{
    var isBusy : Boolean = false
    var timeLeft : Int = 0
    var plane : Airplane? = null

    fun accept(plane: Airplane){
        this.plane = plane
        timeLeft = plane.timeToFinish
        plane.begin()
        isBusy = true
    }

    fun process(time: Int){
        if (timeLeft > 0)
            timeLeft--

        else{
            printTime(time)
            plane?.finished()
            plane = null
            isBusy = false
        }
    }
}