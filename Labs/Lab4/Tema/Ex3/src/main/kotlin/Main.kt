import java.util.*

fun main(args: Array<String>) {
    var Cipri=User("Ciprian")
    println("*********************************************")
    Cipri.addNote("firstFile.txt",Note())
    println("*********************************************")
    Cipri.addNote("secondFile.txt",Note())
    println("*********************************************")
    Cipri.printNote("firstFile.txt")
    println("*********************************************")
    Cipri.printNote("secondFile.txt")
    println("*********************************************")
    Cipri.deleteNote("firstFile.txt")


}