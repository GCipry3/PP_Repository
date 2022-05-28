interface Implementation{
    fun setPowered(value:Boolean)
    fun setBrightness(value:Int)
    fun getPowered():Boolean
    fun getBrightness():Int
}

class Led : Implementation{
    private var powered:Boolean=false
    private var brightness=0

    override fun setPowered(value: Boolean) {
        powered=value
    }

    override fun setBrightness(value: Int) {
        brightness = if(value>=255) {
            255
        }else if(value<0){
            0
        }else{
            value
        }
    }

    override fun getPowered() = powered

    override fun getBrightness() = brightness

}

class Monitor : Implementation{
    private var powered:Boolean=false
    private var brightness=0

    override fun setPowered(value: Boolean) {
        powered=value
    }

    override fun setBrightness(value: Int) {
        brightness = if(value>=100) {
            100
        }else if(value<0){
            0
        }else{
            value
        }
    }

    override fun getPowered() = powered

    override fun getBrightness() = brightness


}

class Abstraction { //this is the bridge
    lateinit var i:Implementation
    constructor(imp:Implementation){
        i=imp
    }

    fun togglePower(){
        if(i.getPowered()) powerOff()
        else powerOn()
    }

    fun raiseBrightness(){
        i.setBrightness(i.getBrightness()+5)
    }

    fun lowerBrightness(){
        i.setBrightness(i.getBrightness()-5)
    }

    private fun powerOn(){
        i.setPowered(true)
    }

    private fun powerOff(){
        i.setPowered(false)
    }
}