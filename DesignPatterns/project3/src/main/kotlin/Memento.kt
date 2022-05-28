data class Memento(val state:String)

class Originator{
    var state:String? =null

    fun createMemento():Memento{
        return Memento(state!!)
    }
    fun setMemento(memento:Memento){
        state=memento.state
    }
}

class Caretaker{
    private val statesList=ArrayList<Memento>()
    fun addMemento(m:Memento){
        statesList.add(m)
    }
    fun getMemento(index :Int)=statesList[index]
}

fun main(){
    val originator= Originator()

    originator.state="Ironman"
    var memento=originator.createMemento()

    val caretaker = Caretaker()
    caretaker.addMemento(memento)

    originator.state="CaptainAmerica"
    originator.state="Hulk"

    memento=originator.createMemento()
    caretaker.addMemento(memento)

    originator.state="Thor"

    println("Stare curenta Origine: "+originator.state!!)
    println("Restaurare Origine...")
    memento=caretaker.getMemento(1)
    originator.setMemento(memento)

    println("Stare curenta Origine: "+originator.state!!)
    println("Din nou Restaurare...")
    memento=caretaker.getMemento(0)
    originator.setMemento(memento)

    println("Stare curenta Origine: "+originator.state!!)
}