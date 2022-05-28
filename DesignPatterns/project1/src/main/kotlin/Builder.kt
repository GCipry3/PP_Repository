class Car{
    var type:String="#TBD#"
    var nrOfSeats:Int =0
    var engine:String="#TBD#"
    var transmission:String="#TBD#"
    var tripComputer:String="#TBD#"
    var gpsNavigator:Boolean= false
}

interface Builder{
    fun setCarType(type: String)
    fun setSeats(nrOfSeats: Int)
    fun setEngine(engine: String)
    fun setTransmission(transmission: String)
    fun setTripComputer(tripComputer: String)
    fun setGPSNavigator(gpsNavigator: Boolean)
    fun create():Car
    fun reset()
}

class CarBuilder : Builder {
    var car=Car()

    override fun setCarType(type: String) {
        car.type=type
    }

    override fun setSeats(nrOfSeats: Int) {
        car.nrOfSeats=nrOfSeats
    }

    override fun setEngine(engine: String) {
        car.engine=engine
    }

    override fun setTransmission(transmission: String) {
        car.transmission=transmission
    }

    override fun setTripComputer(tripComputer: String) {
        car.tripComputer=tripComputer
    }

    override fun setGPSNavigator(gpsNavigator: Boolean) {
        car.gpsNavigator=gpsNavigator
    }

    override fun create(): Car {
        return car
    }

    override fun reset() {
        car=Car()
    }
}