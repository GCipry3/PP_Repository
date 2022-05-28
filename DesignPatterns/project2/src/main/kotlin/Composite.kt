interface Product{
    fun getPrice():Double
    fun applyDiscount(percent:Int)
    fun getExpMonth():Int
}

class Cheese:Product{
    private var price:Double =-1.0
    private var expMonth=-1
    private var type=""

    constructor(p:Double, expM:Int){
        price=p
        this.expMonth =expM
    }

    override fun getPrice() = price

    override fun applyDiscount(percent: Int) {
        price-=price*percent/100
    }

    override fun getExpMonth() = expMonth

    fun setType(str:String){type=str}
}

class Yogurt:Product{
    private var price:Double =-1.0
    private var expMonth=-1
    private var greek=false

    constructor(p:Double, expM:Int){
        price=p
        this.expMonth =expM
    }

    override fun getPrice() = price

    override fun applyDiscount(percent: Int) {
        price-=price*percent/100
    }

    override fun getExpMonth() = expMonth

    fun setGreek(value:Boolean){greek=value}
}

class Cake:Product{
    private var price:Double =-1.0
    private var expMonth=-1

    constructor(p:Double, expM:Int){
        price=p
        this.expMonth =expM
    }

    override fun getPrice() = price

    override fun applyDiscount(percent: Int) {
        price-=price*percent/100
    }

    override fun getExpMonth() = expMonth
}

class Composite:Product{
    private var leafs:MutableList<Product> = mutableListOf()

    fun addChild(child:Product) {
        leafs.add(child)
    }

    override fun getPrice(): Double {
        var sum=0.0
        leafs.forEach{
            sum+=it.getPrice()
        }
        return sum
    }

    override fun applyDiscount(percent: Int) {
        leafs.forEach{
            it.applyDiscount(percent)
        }
    }

    override fun getExpMonth(): Int {
        var sum=0
        leafs.forEach{
            sum+=it.getExpMonth()
        }
        return sum/leafs.size
    }

}

fun main(){
    var products:Composite=Composite()

    products.addChild(Cheese(20.0,1))
    products.addChild(Cheese(21.0,5))
    products.addChild(Cheese(23.0,2))
    products.addChild(Cheese(24.0,1))

    var products2=Composite()

    products2.addChild(Cake(100.0,2))
    products2.addChild(Yogurt(150.0,5))
    products2.applyDiscount(12)
    println(products2.getExpMonth())

    products.addChild(products2)

    println(products.getPrice().toString()+"\n"+products.getExpMonth().toString())
}