import kotlin.random.Random

fun getSubCollectionsWith4El(list:List<Int>): List<List<Int>> {
    return list.flatMap { e1-> list.flatMap{ e2-> list.flatMap{ e3-> list.flatMap{e4-> list.map{listOf(e1,e2,e3,e4)}}} } }
}

fun main(args: Array<String>) {
    var c1= generateSequence(0){it+1}.take(15).map{it*(Random.nextInt()%10) }.toList()
    var c2= generateSequence(0){it+1}.take(15).map{it*(Random.nextInt()%10) }.toList()
    println(c1)
    println(c2)
    var cartesian=c1.flatMap { c1Element -> c2.map { c2Element -> listOf(c1Element,c2Element) } }


    /*fun hasDuplications(x: List<Int>):Boolean{
        var counter=0
        x.forEach{ x1->
            x.forEach{
                x2->
                    if(x1==x2) counter++
                    if(counter>=2) return true
            }
            counter=0
        }
        return false
    }
    var list= generateSequence(0) {it+1}.take(10).toList()
    var subCol=getSubCollectionsWith4El(list)
    subCol.filter{ !hasDuplications(it) }.map{it.sorted()}.distinct().forEach(::println)*/

    println(cartesian)
}