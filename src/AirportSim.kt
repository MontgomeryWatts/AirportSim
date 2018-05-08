import java.util.Random

fun main(args: Array<String>){

    val landingQueue = AirplaneQueue()
    val takeoffQueue = AirplaneQueue()
    val r = Runway()
    var time = 0
    var plane: Airplane?

    if(args.size != 5){
        printUsage()
        return
    }


    val landingChance = args[0].toInt()
    val takeoffChance = args[1].toInt()
    val landTime = args[2].toInt()
    val toTime = args[3].toInt()
    val airborne = args[4].toInt()

    while (true) {

        //Check if new planes have arrived
        if( Random().nextInt() % 100 <= landingChance){
            printTime(time)
            plane = Airplane(landTime, airborne, true, time)
            landingQueue.add(plane)
        }
        if( Random().nextInt() % 100 <= takeoffChance) {
            printTime(time)
            plane = Airplane(toTime, airborne, false, time)
            takeoffQueue.add(plane)
        }

        //Check if first plane in the landing queue has crashed
        plane = landingQueue.peek()
        while ((plane != null) && plane.maxTimeAirborne == time - plane.timeArrived) {
            printTime(time)
            landingQueue.remove()?.crash()
            plane = landingQueue.peek()
        }

        //If the runway is empty, check if there is a plane waiting
        if(!r.isBusy){
            plane = null
            if(!landingQueue.isEmpty())
                plane = landingQueue.remove()
            else if (!takeoffQueue.isEmpty())
                plane = takeoffQueue.remove()
            if (plane != null) {
                printTime(time)
                r.accept(plane)
            }
        }
        else { //runway is not empty, have runway process its plane
            r.process(time)
        }

        time++
        Thread.sleep(1000)
    }
}

fun printTime(timer: Int) = print("Minute $timer: ")
fun printUsage(){
    println("landingChance takeoffChance landingTime takeoffTime timeAirborne")
}