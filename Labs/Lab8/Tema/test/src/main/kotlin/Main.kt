/*
interface State {
    fun doAction(context: Context?)
}

class StartState : State {
    override fun doAction(context: Context?) {
        println("Player is in start state")
        context?.setState(this)
    }

    override fun toString(): String {
        return "Start State"
    }
}

class StopState : State {
    override fun doAction(context: Context?) {
        println("Player is in stop state")
        context?.setState(this)
    }

    override fun toString(): String {
        return "Stop State"
    }
}

class Context {
    var state: State? = null
    @JvmName("setState1")
    @Override
    fun setState(s:State){
        this.state=s
    }

    @JvmName("getState1")
    @Override
    fun getState(): State? {
        return state
    }
}
*/
/*
object StatePatternDemo {
    @JvmStatic
    fun main(args: Array<String>) {
        val context = Context()
        val startState = StartState()
        startState.doAction(context)
        println(context.state.toString())
        val stopState = StopState()
        stopState.doAction(context)
        println(context.state.toString())
    }
}
*/
fun main(){
    val A = listOf(1, 2, 3)
    val B = listOf(3, 4, 5)

    val AxB = A.flatMap { a -> B.map { b -> a to b } }// produs cartezian
    val BxB= B.flatMap { a -> B.map { b -> a to b } }

    println("AxB: $AxB")
    println("BxB: $BxB")

    val AxB_U_BxB = (AxB + BxB).distinct()//reuniune

    print("AxB U BxB: $AxB_U_BxB")
}