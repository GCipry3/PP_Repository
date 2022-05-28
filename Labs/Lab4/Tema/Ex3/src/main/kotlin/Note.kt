import java.util.*

class Note
{
    private var content:Content?=null
    private var data:Data?=null
    private var ora:String?=null

    constructor(content:Content,data:Data,ora:String)
    {
        this.content=content
        this.data=data
        this.ora=ora
    }

    constructor()
    {
        data=Data()
        content=Content()
        ora=""
    }

    fun setContent(title:String,description: String,deadLine: Data)
    {
        content?.setTitle(title)
        content?.setDescription(description)
        content?.setDeadLineByDate(deadLine)
    }

    fun setDataByDate(data:Data)
    {
        this.data=data
    }

    fun setData(year:Int,month:Int,day:Int)
    {
        data?.setDay(day)
        data?.setMonth(month)
        data?.setYear(year)
    }

    fun setHour(ora:String)
    {
        this.ora=ora
    }

    fun noteString():String
    {
        var rez:String=""
        rez+="\nNote:\n"
        rez+="\tDate: ${data?.getDateString()}\n"
        rez+="\tHour: $ora\n"
        rez+= content?.contentString()
        return rez
    }
    fun noteStringPlusRead():String
    {
        val reader = Scanner(System.`in`)
        println("Introduceti Data: ")
        data?.readData()

        print("\nIntroduceti Ora: ")
        ora=reader.nextLine()

        println("Introduceti Content: ")
        content?.readContent()

        var rez:String=""
        rez+="\nNote:\n"
        rez+="\tDate: ${data?.getDateString()}\n"
        rez+="\tHour: $ora\n"
        rez+= content?.contentString()
        return rez
    }

}