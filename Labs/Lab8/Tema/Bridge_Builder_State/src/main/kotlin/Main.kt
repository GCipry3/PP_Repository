import java.util.*
import java.util.stream.IntStream.range

interface Builder{
    fun reset()
    fun build2(val1:Boolean,val2:Boolean)
    fun build3(val1:Boolean,val2:Boolean,val3:Boolean)
    fun build4(val1:Boolean,val2:Boolean,val3:Boolean,val4:Boolean)
    fun build8(val1:Boolean,val2:Boolean,val3:Boolean,val4:Boolean,val5:Boolean,val6:Boolean,val7:Boolean,val8:Boolean)
    fun buildOneMore(v:Boolean)
    fun build():Product
}

class CBuilder1:Builder{
    var product:Product= Product()
    override fun reset() {
        product.reset()
    }

    override fun build2(val1: Boolean, val2: Boolean) {
        product.reset()
        product.add(val1)
        product.add(val2)
    }

    override fun build3(val1: Boolean, val2: Boolean, val3: Boolean) {
        product.reset()
        product.add(val1)
        product.add(val2)
        product.add(val3)
    }

    override fun build4(val1: Boolean, val2: Boolean, val3: Boolean, val4: Boolean) {
        product.reset()
        product.add(val1)
        product.add(val2)
        product.add(val3)
        product.add(val4)
    }

    override fun build8(
        val1: Boolean,
        val2: Boolean,
        val3: Boolean,
        val4: Boolean,
        val5: Boolean,
        val6: Boolean,
        val7: Boolean,
        val8: Boolean
    ) {
        product.reset()
        product.add(val1)
        product.add(val2)
        product.add(val3)
        product.add(val4)
        product.add(val5)
        product.add(val6)
        product.add(val7)
        product.add(val8)
    }

    override fun buildOneMore(v: Boolean) {
        product.add(v)
    }

    override fun build(): Product {
        return this.product
    }

}

class Product{
    var list:List<Boolean> = listOf()
    fun reset(){
        list= listOf()
    }

    fun add(value:Boolean){
        this.list=this.list.plus(value)
    }

    override fun toString(): String {
        return "\nProdusul contine: $list"
    }
}

class Director{
    var builder:Builder
    lateinit var state:State

    constructor(b:Builder){
        this.builder=b
    }

    @JvmName("setBuilder1")
    fun setBuilder(b:Builder){
        this.builder=b
    }

    fun make(type:Int){
        var list = listOf<Boolean>()
        for (i in range(1,type+1)){
            var reader= Scanner(System.`in`)

            print("Introduceti a $i valoare<Boolean>: ")
            var tmp:Boolean = reader.nextBoolean()

            list=list.plus(tmp)
        }
        builder.reset()
        when(type){
            2->{
                builder.build2(list[0],list[1])

                /*state=CState2(builder.build().list)
                println(state)
                println(state.doAnd())*/
            }
            3->{
                builder.build3(list[0],list[1],list[2])

                /*state=CState3(builder.build().list)
                println(state)
                println(state.doAnd())*/
            }
            4->{
                builder.build4(list[0],list[1],list[2],list[3])

                /*println(builder.build())

                state=CState4(builder.build().list)
                println(state)
                println(state.doAnd())*/
            }
            8->{
                builder.build8(list[0],list[1],list[2],list[3],list[4],list[5],list[6],list[7])

                /*var l=builder.build().list
                state=trueState(l[0],l[1])

                for(i in range(0,type)){
                    state.set(l[0],l[1])
                    state= state.update()
                    println(state)
                }*/
            }
        }

        var l=builder.build().list
        state=trueState(l[0],l[1])

        for(i in range(0,type)){
            state.set(state.var1,l[i])
            state= state.update()
            print("$i: $state\t")
        }
        println()
        println()
    }

}

abstract class State{
    abstract var var1:Boolean
    abstract var var2:Boolean
    //fun doAnd():Boolean
    abstract fun update():State
    abstract fun set(v1:Boolean,v2:Boolean)
    abstract override fun toString(): String
}

class trueState:State{
    override var var1:Boolean
    override var var2:Boolean

    constructor(v1:Boolean,v2:Boolean){
        var1=v1
        var2=v2
    }

    override fun set(v1:Boolean, v2:Boolean){
        var1=v1
        var2=v2
    }
    override fun update(): State {
        return if(var1 and var2){
            var1=var1 and var2
            this
        }else{
            falseState(var1,var2)
        }
    }

    override fun toString(): String {
        return "TrueState"
    }

}

class falseState:State{
    override var var1:Boolean
    override var var2:Boolean

    constructor(v1:Boolean,v2:Boolean){
        var1=v1
        var2=v2
    }
    override fun set(v1:Boolean, v2:Boolean){
        var1=v1
        var2=v2
    }

    override fun update(): State {
        var1=var1 and var2
        return this
    }

    override fun toString(): String {
        return "FalseState"
    }

}
/*
class CState2:State{
    private var product:List<Boolean> = listOf()

    constructor(p:List<Boolean>){
        product=p
    }


    override fun doAnd() :Boolean{
        val listTmp=product.take(2).filter { !it }
        if (listTmp.isEmpty()){
            return true
        }
        return false
    }

    override fun toString(): String {
        return "\nAutomat AND cu 2 intrari"
    }
}

class CState3:State{
    private var product:List<Boolean> = listOf()

    constructor(p:List<Boolean>){
        product=p
    }

    override fun doAnd() :Boolean{
        val listTmp=product.take(3).filter { !it }
        if (listTmp.isEmpty()){
            return true
        }
        return false
    }

    override fun toString(): String {
        return "\nAutomat AND cu 3 intrari"
    }
}

class CState4:State{
    private var product:List<Boolean> = listOf()

    constructor(p:List<Boolean>){
        product=p
    }

    override fun doAnd() :Boolean{
        val listTmp=product.take(4).filter { !it }
        if (listTmp.isEmpty()){
            return true
        }
        return false
    }

    override fun toString(): String {
        return "\nAutomat AND cu 4 intrari"
    }
}


class CState8:State{
    private var product:List<Boolean> = listOf()

    constructor(p:List<Boolean>){
        product=p
    }

    override fun doAnd() :Boolean{
        val listTmp=product.take(8).filter { !it }
        if (listTmp.isEmpty()){
            return true
        }
        return false
    }

    override fun toString(): String {
        return "\nAutomat AND cu 8 intrari"
    }
}*/

fun main(args: Array<String>) {
    var director=Director(CBuilder1())
    director.make(2)
    director.make(3)
    director.make(4)
    director.make(8)

}