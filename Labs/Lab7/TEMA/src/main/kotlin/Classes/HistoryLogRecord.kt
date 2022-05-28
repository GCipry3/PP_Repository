package Classes

import java.sql.Timestamp

class HistoryLogRecord<T> :Comparable<T>{
    var timestamp:Timestamp=Timestamp(0,0,0,0,0,0,0)
    var command:String=""

    constructor(t : Timestamp,c: String)
    {
        timestamp=t
        command=c
    }

    override fun compareTo(other: T): Int {
        return this.compareTo(other)
    }

    override fun toString() :String
    {
        return "  $command\n"
    }

}