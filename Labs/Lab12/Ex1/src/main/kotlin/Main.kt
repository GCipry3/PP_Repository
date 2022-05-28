import java.io.File
import java.lang.Math.sqrt

/*class Transformer{
    fun upperCased(str: String):String{
        return str.toUpperCase()
    }
    companion object{
        fun lowerCased(str:String):String{
            return str.toLowerCase()
        }
    }
}*/

fun main(args: Array<String>) {
    /*val capitalize1= { str:String -> str.capitalize()}
    println(capitalize1("hello world!"))
    println()

    fun <T>varargFun (vararg items:T){
        items.forEach ( ::println )
    }
    varargFun(1,5,"5t")
    println()
    fun <T> emit(t:T,vararg listeners:(T) -> Unit)=listeners.forEach {
        listener->listener(t)
    }
    emit(listOf('a','b','c'),::println,
        {i->println(i.joinToString (prefix="<",
                                    postfix = ">",
                                    separator = "-=-"))})
    println()

    fun capitalizeFun(str:String)=capitalize1(str)
    fun<T> transform(t:T,fn:(T)->T):T{
        return fn(t)
    }
    println(transform("kotlin", { str: String -> capitalize1(str) } ))
    println(transform("kotlin", {it.capitalize()}))
    println(transform("kotlin", (::capitalizeFun)))
    println()

    fun reverse(str: String):String{
        return str.reversed()
    }
    println(transform("kotlin",::reverse))
    println()

    val transformer=Transformer()
    println("upper: "+transform("kotlin",transformer::upperCased))
    println("lower: "+transform("KOTLIN",Transformer::lowerCased))
    println()

    fun performOperationOnEven(nr:Int,operation:(Int)->Int):Int{
        return if(nr%2==0){
            operation(nr)
        }else{
            nr
        }
    }
    println("Callerd with 4,(it*2) :${performOperationOnEven(4,{nr:Int->nr*2})}")
    println("Callerd with 5,(it*2) :${performOperationOnEven(5,{nr:Int->nr*2})}")
    println()

    fun String.reverse(): String {
        return reverse(this)
    }
    println("Reverse from extension fun: ${"kotlin".reverse()}")
    println()

    val list=1.until(5).toList()
    println(list.filter { it%2==0 })
    println(list.map{it*2})
    println(list.flatMap { it -> 1.until(it).toList().map {i:Int-> i * 10 }})
    //println(list.fold(0.0){acc,i->acc+i} )
    //println(list.fold(15.0){acc,i->acc+i})
    //println(list.reduce{acc,i->acc*i})
    val (even,odd)=list.partition { it%2==0 }
    println(even)
    println(odd)
    println("distinct: "+listOf(1,1,1,1,1,2,5).distinct())
    println("drop: "+1.until(20).toList().drop(5).dropLast(3))
    val list1=1.until(5).toList()
    val list2=list1.subList(1,list1.size-1)
    println(list1.zip(list1.subList(0,list1.size-2)))
    println(list1.zipWithNext())
    println(list1.zipWithNext(){a,b->a*b})
    println(list1.flatMap { i -> list2.map{j-> i to j} })*/
    println("--------PRB1--------------")
    val list1=listOf(1,21,75,39,7,2,35,3,31,7,8)
    val list2=list1.filter { it>=5 }
    var i=0
    val (list3_1,list3_2)=list2.partition{i++%2==0}
    val list3=list3_1.zip(list3_2)
    val list4=list3_1.zip(list3_2){a,b->a*b}
    val sum=list4.reduce{acc,it->acc+it}

    println(list1)
    println(list2)
    println(list3)
    println(list4)
    println(sum)

    println("\n\n--------PRB2--------------")

    fun stringSizeBetween4and7(x:String):Boolean{
        return x.length in 4..7
    }


    fun String.caesar(offset:Int):String{
        val str =this.map {
            if(it in 'a'..'z'){
                if(it+offset>'z'){
                    var newOffset=offset
                    newOffset -= 'Z' - it

                    'A' + newOffset -1
                }else{
                    it+offset
                }
            }else {
                if (it + offset > 'Z') {
                    var newOffset = offset

                    newOffset -= 'Z' - it

                    'A' + newOffset -1
                } else {
                    it + offset
                }
            }
        }
        return str.joinToString(
            prefix = "",
            postfix = "",
            separator = ""
        )
    }

    val list=File("text.txt").bufferedReader().readLines().filter(::stringSizeBetween4and7)

    val newList1=list.map{
        it.caesar(1)
    }
    val newList2=list.map{
        it.caesar(2)
    }

    println("Original:\t$list")
    println("Offset 1:\t$newList1")
    println("Offset 2:\t$newList2")

    println("\n\n--------PRB3--------------")

    var listPrb3=File("prb3").bufferedReader().readLines().joinToString(separator = " ").split(" ").map { it.toInt() }.toList()
    val numberOfPoints:Int= listPrb3[0]
    listPrb3=listPrb3.drop(1)

    i=0
    val (list_x,list_y)=listPrb3.partition { i++%2==0 }

    val listPrb3_new=list_x.zip(list_y).toMutableList()
    listPrb3_new.add(Pair(0,0))
    println(listPrb3_new)

    var p=0.0;
    for (i :Int in 0 until numberOfPoints) {
        val f1=listPrb3_new[i].first.toDouble()
        val s1=listPrb3_new[i].second.toDouble()
        val f2=listPrb3_new[i+1].first.toDouble()
        val s2=listPrb3_new[i+1].second.toDouble()
        println("$f1 $s1 $f2 $s2")

        p+= kotlin.math.sqrt((f1 - f2) * (f1 - f2) + (s1 - s2) * (s1 - s2))
    }

    println(p)


}


