import java.util.*

class Content
{
    private var title:String?=null
    private var author:String?=null
    private var description:String?=null
    private var deadLine:Data?=null
    constructor(title:String,author:String,description:String,deadLine:Data)
    {
        this.title=title
        this.description=description
        this.deadLine=deadLine
        this.author=author
    }
    constructor()
    {
        title=""
        author=""
        description=""
        deadLine=Data()
    }


    fun readContent()
    {
        val reader = Scanner(System.`in`)
        print("\nAuthor: ")
        author=reader.nextLine()
        print("\nTitle: ")
        title=reader.nextLine()
        print("\nDescription: ")
        description=reader.nextLine()
        print("\nDeadLine: ")
        deadLine?.readData()

    }

    fun setTitle(title:String)
    {
        this.title=title
    }

    fun setAuthor(author:String)
    {
        this.author=author
    }

    fun setDescription(description:String)
    {
        this.description=description
    }

    fun setDeadLine(year:Int,month:Int,day:Int)
    {
        deadLine?.setDay(day)
        deadLine?.setMonth(month)
        deadLine?.setYear(year)
    }
    fun setDeadLineByDate(deadLine:Data)
    {
        this.deadLine=deadLine
    }

    fun contentString(): String
    {
        var rez:String=""
        rez+="\n\tContent: \n"
        rez+="\t\tTitle: $title\n"
        rez+="\t\tAuthor: $author\n"
        rez+="\t\tDescription: $description\n"
        rez+="\t\tDeadLine: ${deadLine?.getDateString()}\n"

        return rez
    }

}
