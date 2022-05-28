interface Prototype {
    fun clone():Prototype
}

class House:Prototype{
    private var houseColor:String=""
    private var nrOfWindows:Int = 0
    private var nrOfDoors:Int = 0

    constructor(){}

    constructor(houseColor:String,nrOfWindows:Int,nrOfDoors:Int ){
        this.houseColor=houseColor
        //delay(10 sec)
        this.nrOfDoors=nrOfDoors
        //delay(10 sec)
        this.nrOfWindows=nrOfWindows
        //delay(10 sec)
    }//total constructor time = 30sec

    fun setHouseColor(hC:String){houseColor=hC}
    fun setNrOfWindows(nrW:Int){nrOfWindows=nrW}
    fun setNrOfDoors(nrD:Int){nrOfDoors}

    override fun clone(): Prototype {
        val houseClone=House()

        houseClone.setHouseColor(houseColor)
        houseClone.setNrOfWindows(nrOfWindows)
        houseClone.setNrOfDoors(nrOfDoors)

        return houseClone
    }//total clone type = approx 0sec
}