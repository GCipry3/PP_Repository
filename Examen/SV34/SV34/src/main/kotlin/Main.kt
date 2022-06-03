import java.io.File

fun main(args: Array<String>) {
    val testLengthBiggerThan4:(String)->Boolean={ it.length>=4 }

    var listOfWordsFromFile= File("text.txt").readLines().joinToString(" ").split(" ").toList()
    println(listOfWordsFromFile)

    var rez=listOfWordsFromFile.map{
        if(testLengthBiggerThan4(it)) it.substring(2,it.length).toList().joinToString(prefix = "<", postfix = ">", separator = "")
        else it
    }

    println(rez)
}