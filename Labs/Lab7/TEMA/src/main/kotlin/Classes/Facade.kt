package Classes

import Command
import TimestampData
import java.io.File
import java.sql.Timestamp
import java.util.stream.IntStream.range

fun <T> compareHLR(first: T,second: T) :Int
        where T:Comparable<T>
{
    return first.compareTo(second)
}


class Facade{
    var cmds= Command()
    var times= TimestampData()
    var hashmap:HashMap<Timestamp,HistoryLogRecord<Timestamp>> = hashMapOf()

    fun Execute(filename:String)
    {
        var lines= File(filename).readLines().filter { it != "" }.filter{it != "\n"}.take(250).toMutableList()
        var commands=lines.filter{it.startsWith("Commandline: ")}.map{it.substring(13)}.toMutableList()
        var startDates=lines.filter{it.startsWith("Start-Date: ")}.map{it.substring(12)}.toMutableList()

        cmds.Set(commands)
        times.dates.Set(startDates)
        times.ConvertStringToTimestamp()
        var i=0
        for(i in range(0,commands.size))
        {
            hashmap.put(times.timestamps.elementAt(i), HistoryLogRecord(times.timestamps.elementAt(i),cmds.commands.elementAt(i)))
        }
        //println(hashmap)
    }



}