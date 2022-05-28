import java.util.Scanner
class Data
{
    private var year:Int?=null
    private var month:Int?=null
    private var day:Int?=null
    constructor(y:Int,m:Int,d:Int)
    {
        year=y
        month=m
        day=d
    }

    constructor()
    {
        year=0
        month=0
        day=0
    }

    fun readData()
    {
        val reader = Scanner(System.`in`)
        print("\nYear: ")
        year=reader.nextInt()
        print("\nMonth: ")
        month=reader.nextInt()
        print("\nDay: ")
        day=reader.nextInt()
    }

    fun setYear(data:Int)
    {
        this.year=data
    }
    fun setMonth(data:Int)
    {
        this.month=data
    }
    fun setDay(data:Int)
    {
        this.day=data
    }
    fun getDateString():String
    {
        var aux:String=""
        var tmp:String=""

        tmp=day.toString()
        aux+=tmp

        tmp= ".$month."
        aux+=tmp

        tmp=year.toString()
        aux+=tmp

        return aux
    }

}