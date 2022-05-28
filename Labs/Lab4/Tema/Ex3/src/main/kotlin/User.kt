import java.io.File

class User
{
    private val user:String
    //var notes:MutableList<Note>? = null
    var fileNames:MutableList<String>? = null

    constructor(user:String)
    {
        this.user=user
    }

    fun addNote(fileName:String,note:Note)
    {
        val file=File(fileName)

        file.writeText(note.noteStringPlusRead())
        //notes?.add(note)
        fileNames?.add(fileName)
    }

    fun printNote(fileName:String)
    {
        val file = File(fileName)
        file.forEachLine {
            println(it)
        }

    }

    fun deleteNote(fileName:String)
    {
        val file = File(fileName)

        if(fileNames?.indexOf(fileName)!=-1)
        {
            fileNames?.remove(fileName)
            val result = file.delete()
            if (result) {
                println("Deletion succeeded.")
            } else {
                println("Deletion failed.")
            }
        }
        else
        {
            println("!!!!!!!!!!!!!!!!!!!! Error on deleteNote , the file could not be found")
        }
    }
    fun deleteAllNotes()
    {
        var fileName : String
        for(fileName in fileNames!!)
        {
            deleteNote(fileName)
        }
    }


}