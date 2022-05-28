import java.io.File
import javax.xml.crypto.Data

interface DataSource{
    fun readData():String
    fun writeData(data:String)
}

class FileDataSource(private var fileName:String) : DataSource{
    fun setFileName(fName:String){
        fileName=fName
    }

    override fun readData(): String {
        return File(fileName).readText()
    }

    override fun writeData(data: String) {
        File(fileName).writeText(data)
    }
}

class EncryptionDecorator(private var dataS:DataSource):DataSource{

    override fun readData()=decryptionData(dataS.readData())

    override fun writeData(data: String) {
        dataS.writeData(encryptionData(data))
    }

    public fun writeDecryptedData(data:String){
        dataS.writeData(data)
    }

    private fun encryptionData(data:String):String{
        return data.map { it+1 }.toList().joinToString(separator = "")
    }

    private fun decryptionData(data:String):String{
        return data.map { it-1 }.toList().joinToString(separator = "")
    }

}

fun main(){
    var dataSource:DataSource=FileDataSource("tmp.txt")
    dataSource.writeData("Hi There\n\tMy name is Ciprian")
    println(dataSource.javaClass.name+":\n\t"+dataSource.readData())

    var encryptionDataSource:DataSource=EncryptionDecorator(dataSource)
    //(encryptionDataSource as EncryptionDecorator).writeDecryptedData(dataSource.readData())
    encryptionDataSource.writeData(dataSource.readData())
    println(encryptionDataSource.javaClass.name+":\n\t"+encryptionDataSource.readData())

}