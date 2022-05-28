import kotlin.math.pow
import kotlin.math.sqrt


class RoundHole(private var radius:Int){
    @JvmName("getRadius1")
    fun getRadius()=radius
    fun fits(peg:RoundPeg) = radius>=peg.getRadius()

}

interface RoundPeg{
    fun getRadius():Int
}

open class ConcreteRoundPeg:RoundPeg{
    private var radius:Int=0
    constructor(radius:Int)  {
        this.radius=radius
    }

    override fun getRadius()= radius
}

class SquarePeg(private var width:Int){
    fun getWidth()=width
    fun getArea()= width.toDouble().pow(2.0).toInt()
}

class Adapter(private var peg:SquarePeg): RoundPeg {
    override fun getRadius()=(peg.getWidth()* sqrt(2.0) /2).toInt()
}//squarePegAdapter

fun main(){
    val hole = RoundHole(5)

    val rPeg=ConcreteRoundPeg(6)
    if(hole.fits(rPeg)) println("rPeg fits in the hole")
    else println("rPeg does not fit in the hole")

    val smallPeg=SquarePeg(2)
    val largePeg=SquarePeg(20)

    val smallPegAdapter=Adapter(smallPeg)
    val largePegAdapter=Adapter(largePeg)

    if(hole.fits(smallPegAdapter)) println("smallPeg fits in the hole")
    else println("smallPeg does not fit in the hole")

    if(hole.fits(largePegAdapter)) println("largePeg fits in the hole")
    else println("largePeg does not fit in the hole")
}