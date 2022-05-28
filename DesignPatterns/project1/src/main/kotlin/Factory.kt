interface ABC{
    fun operation()
}

class A(_str:String):ABC{
    var str=_str
    override fun operation(){
        println("Hello from class A, i have this message: ${this.str}")
    }
}
class B(_str:String):ABC{
    var str=_str
    override fun operation(){
        println("Hello from class B, i have this message: ${this.str}")
    }
}
class C(_str:String):ABC{
    var str=_str
    override fun operation(){
        println("Hello from class C, i have this message: ${this.str}")
    }
}

class Factory() {
    fun factoryABC(type:String):ABC{
        return when(type){
            "A"-> A(" Hi boss ^^")
            "B"-> A(" Hi boss :D")
            "C"-> A(" Hi boss :)")
            else -> throw java.lang.RuntimeException("factory type is wrong")
        }
    }
}