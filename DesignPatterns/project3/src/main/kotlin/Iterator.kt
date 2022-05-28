interface Iterator<T>{
    fun first()
    fun next()
    fun prev()
    fun currentElement() : T
    fun isDone():Boolean
}

class ListIterator<T>(private var list:List<T>) :Iterator<T>{
    private var index=0
    override fun first() {
        index=0
    }

    override fun next() {
        index++
    }

    override fun prev() {
        if(index>0){
            index--
        }
    }

    override fun currentElement(): T {
        return list[index]
    }

    override fun isDone(): Boolean {
        return index>list.size
    }

    fun sizeOfList():Int{
        first()
        while(!isDone()){
            next()
        }
        val result= index-1
        first()
        return result
    }
}

fun main(){
    var iterator=ListIterator<Int>(listOf(1,100,-1,2,55,4,2))
    println("SizeOfList: "+iterator.sizeOfList())
    println("Current element: "+iterator.currentElement())
    iterator.next()
    iterator.next()
    iterator.next()
    println("Current element: "+iterator.currentElement())
}