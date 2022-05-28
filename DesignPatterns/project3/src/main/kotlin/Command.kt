import java.io.File

var clipBoard:String=""

interface Command{
    fun execute()
}

class Paste(private var fileName:String): Command{
    override fun execute() {
        File(fileName).appendText(clipBoard)
    }

    override fun toString(): String {
        return " <Paste Command> "
    }
}

class Copy(private var fileName:String):Command{
    override fun execute(){
        clipBoard=File(fileName).readText()
    }
    override fun toString(): String {
        return " <Copy Command> "
    }
}

class PutInClipboard(private var str:String):Command{
    override fun execute() {
        clipBoard=str
    }
    override fun toString(): String {
        return " <PutInClipboard Command> "
    }
}

class CommandHistory{
    private val history : MutableList<Command> = mutableListOf()
    fun addCommand(c:Command){
        history.add(c)
    }

    fun executeAllFromFirstAndClear(){
        history.forEach{it.execute()}
        history.clear()
    }
    fun executeAllFromFirst(){
        history.forEach{it.execute()}
    }

    fun executeLastCommand(){
        history.last().execute()
    }

    fun redoCommand(index:Int){
        if(index<history.size && index>0){
            history[index].execute()
        }else{
            println("Index $index is out of range!")
        }
    }

    fun removeLastCommand(){
        history.removeLast()
    }

    fun printHistory(){
        print("History log of Commands:\n")
        var tmpTabs="\t"
        var i=0
        history.forEach{
            println("${i++}"+tmpTabs+it)
            tmpTabs+="\t"
        }
    }
}

fun main(){
    val history:CommandHistory = CommandHistory()
    history.addCommand(PutInClipboard("Hi\n\tMy name is Ciprian\n\t\tFirstPutInClipboard"))
    history.addCommand(Paste("tmp.txt"))
    history.addCommand(Copy("in.txt"))
    history.addCommand(Paste("tmp.txt"))
    history.addCommand(PutInClipboard(""))
    history.addCommand(PutInClipboard("Hi\n\tMy name is Ciprian\n\t\tSecondPutInClipboard"))

    history.executeAllFromFirst()
    history.executeLastCommand()
    history.redoCommand(1)

    history.printHistory()

    history.removeLastCommand()

    history.printHistory()

    history.executeAllFromFirstAndClear()
}