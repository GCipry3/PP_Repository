interface ProductA{
    fun operation()
}

class A1:ProductA{
    override fun operation() {
        println("Product A1")
    }
}
class A2:ProductA{
    override fun operation() {
        println("Product A2")
    }
}

interface ProductB{
    fun execute()
}
class B1:ProductB{
    override fun execute() {
        println("Product B1")
    }
}
class B2:ProductB{
    override fun execute() {
        println("Product B2")
    }
}

interface AbstractFactory {
    fun createProductA():ProductA
    fun createProductB():ProductB
}

class ConcreteFactory1 :AbstractFactory{
    override fun createProductA() = A1()
    override fun createProductB() = B1()
}

class ConcreteFactory2 :AbstractFactory{
    override fun createProductA() = A2()
    override fun createProductB() = B2()
}