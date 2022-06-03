import java.io.File

class Nod{
    var data:String=""
    var nod1: Nod? =null
    var nod2: Nod? =null

    constructor(d:String){
        data=d
    }

    fun addLeft(nod:Nod){
        nod1=nod
    }

    fun addRight(nod:Nod){
        nod2=nod
    }

}

fun main(args: Array<String>) {
    var list= File("text.txt").readLines().toList().joinToString(separator = " ").split(" ")
    val checkStringLength:(String) -> Boolean={it.length>3}
    val tree=Nod(list[0])
    list=list.subList(1,list.size)
    list.forEach{}
}