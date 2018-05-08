class AirplaneQueue {
    var head : Airplane? = null
    var tail : Airplane? = null

    fun isEmpty() = (head == null)

    fun add(plane: Airplane){
        if(this.isEmpty()){
            head = plane
            tail = plane
        }
        else{
            tail?.nextPlane = plane
            tail = plane
        }
    }

    fun remove() : Airplane?{
        if(this.isEmpty())
            return null
        val plane = head

        if (head == tail)
            tail = null

        head = head?.nextPlane //Head becomes null if there is only one plane in queue
        return plane
    }

    fun peek() : Airplane? = head
}