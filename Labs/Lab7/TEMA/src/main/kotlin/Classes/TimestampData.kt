import java.sql.Timestamp

class TimestampData:Data<Timestamp>
{
    var timestamps = mutableListOf<Timestamp>()
    var dates = Start_Date()

    override fun Get(): MutableList<Timestamp> {
        return timestamps
    }

    override fun Set(list: MutableList<Timestamp>) {
        timestamps=list
    }

    override fun Add(timestamp: Timestamp) {
        timestamps.add(timestamp)
    }

    fun ConvertStringToTimestamp()
    {
        var tmp=dates.Get()
        for (i in tmp)
        {
            var year=i.substring(0,4).toInt()
            var month=i.substring(5,7).toInt()
            var day=i.substring(8,10).toInt()
            var hour=i.substring(12,14).toInt()
            var min=i.substring(15,17).toInt()
            var sec=i.substring(18,20).toInt()

            var aux= Timestamp(year-1900,month-1,day,hour,min,sec,0)
            timestamps.add(aux)
        }
        //println(timestamps)
        /*
        println(tmp.elementAt(0).substring(0,4))
        println(tmp.elementAt(0).substring(5,7))
        println(tmp.elementAt(0).substring(8,11))
        println(tmp.elementAt(0).substring(12,14))
        println(tmp.elementAt(0).substring(15,17))
        println(tmp.elementAt(0).substring(18,20))*/
    }
}