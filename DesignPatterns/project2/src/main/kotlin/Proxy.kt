import java.io.File

/*DataSource is created in Decorator
interface DataSource{
    fun readData():String
    fun writeData(data:String)
}*/

class ConcreteDataSource(private val userName:String,private val pass:String,private val fileName:String):DataSource{

    fun getUserName() = userName
    fun getPass()=pass

    override fun readData(): String {
        return File(fileName).readText()
    }

    override fun writeData(data: String) {
        File(fileName).writeText(data)
    }

}
class DataSourceProxy(private val adminUserName:String,private val adminPass:String,private var dataBase:ConcreteDataSource):DataSource{
    override fun readData(): String {
        return dataBase.readData()
    }

    override fun writeData(data: String) {
        if(isAdmin()){
            dataBase.writeData(data)
        }else{
            for(i in 0..5)print("HACKER!!!!!")
            println()
        }
    }

    fun setDataBase(db:ConcreteDataSource){dataBase=db}

    private fun isAdmin():Boolean{
        return adminUserName==dataBase.getUserName() && adminPass==dataBase.getPass()
    }

}

fun main(){
    val dataBase1=ConcreteDataSource("cipri","12345678","tmp.txt")
    val dataBase2=ConcreteDataSource("cipri","1234567","tmp.txt")

    val dataBaseProxy=DataSourceProxy("cipri","12345678",dataBase1)

    println(dataBaseProxy.readData())
    dataBaseProxy.writeData("Bossuleala db1")
    println(dataBaseProxy.readData())

    dataBaseProxy.setDataBase(dataBase2)
    dataBaseProxy.writeData("Bossuleala db2")
    println(dataBaseProxy.readData())

}