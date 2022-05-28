/*
interface Mediator{
    fun notify(sender: Component,command: String)
}

class ObjectsMediator :Mediator{
    override fun notify(sender: Component, command: String) {
        when(sender){
            is Player -> print("player")
            is Enemy -> print("enemy")
        }
    }
}

interface Component{
    fun attack()
    fun getDamage(damage :Int)
    fun move(_x:Int)
    fun isAlive():Boolean
}

class Player(private var x:Int,private var health:Int):Component{
    private var attack=false
    private var mediator: Mediator =ObjectsMediator()

    override fun move(_x:Int){
        x=_x;
    }

    fun moveLeft(){
        x-=5
    }

    fun moveRight(){
        x+=5
    }

    override fun getDamage(damage:Int){
        health-=damage
    }

    override fun isAlive() = health>0

    private fun setAttack(value : Boolean){attack=value}
    fun getAttack()=attack

    override fun attack(){setAttack(true)}
}

class Enemy(private var x:Int,private var alive:Boolean) :Component{
    private var attack=false
    private var mediator: Mediator =ObjectsMediator()
    override fun attack() {
        TODO("Not yet implemented")
    }

    override fun getDamage(damage: Int) {
        TODO("Not yet implemented")
    }

    override fun move(_x: Int) {
        TODO("Not yet implemented")
    }

    override fun isAlive(): Boolean {
        TODO("Not yet implemented")
    }

}


*/
