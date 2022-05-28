interface Handler{
    fun setNext(h:Handler)
    fun handle(user:User,price:Int)
}

class User(private var name:String,private var cashMoney:Int,private var bankAccountMoney:Int,private var paypalMoney:Int){
    fun setCashMoney(amount:Int)
    {
        cashMoney=amount
        println("CashUpdated:")
        getMoneyDetails()
        //println("$name has $cashMoney$ cashMoney left")
    }
    fun getCashMoney() = cashMoney

    fun setBankAccountMoney(amount:Int)
    {
        bankAccountMoney=amount
        println("BankMoneyUpdated:")
        getMoneyDetails()
        //println("$name has $bankAccountMoney$ bankMoney left")
    }
    fun getBankAccountMoney() = bankAccountMoney

    fun setPaypalMoney(amount:Int)
    {
        paypalMoney=amount
        println("PaypalUpdated:")
        getMoneyDetails()
        //println("$name has $paypalMoney$ paypalMoney left")
    }
    fun getPaypalMoney() = paypalMoney

    fun getName()=name

    private fun getMoneyDetails(){
        println("\t$name:\n\t\thas $paypalMoney\$ paypalMoney left\n" +
                        "\t\thas $bankAccountMoney\$ bankMoney left\n"+
                        "\t\thas $cashMoney\$ cashMoney left")
    }
}

class CashPayment:Handler{
    private var nextH:Handler?=null
    override fun setNext(h: Handler) {
        nextH=h
    }

    override fun handle(user: User, price: Int) {
        var tmpUserCashMoney=user.getCashMoney()

        if(tmpUserCashMoney>=price) user.setCashMoney(tmpUserCashMoney-price)
        else if(nextH!=null){
            nextH?.handle(user,price)
        }else{
            println("Unfortunately user ${user.getName()} does not have enough money ($price$)")
        }
    }
}

class CardPayment:Handler{
    private var nextH:Handler?=null
    override fun setNext(h: Handler) {
        nextH=h
    }

    override fun handle(user: User, price: Int) {
        var tmpUserCashMoney=user.getBankAccountMoney()

        if(tmpUserCashMoney>=price) user.setBankAccountMoney(tmpUserCashMoney-price)
        else if(nextH!=null){
            nextH?.handle(user,price)
        }else{
            println("Unfortunately user ${user.getName()} does not have enough money ($price$)")
        }
    }
}

class PaypalPayment:Handler{
    private var nextH:Handler?=null
    override fun setNext(h: Handler) {
        nextH=h
    }

    override fun handle(user: User, price: Int) {
        var tmpUserCashMoney=user.getPaypalMoney()

        if(tmpUserCashMoney>=price) user.setPaypalMoney(tmpUserCashMoney-price)
        else if(nextH!=null){
            nextH?.handle(user,price)
        }else{
            println("Unfortunately user ${user.getName()} does not have enough money ($price$)")
        }
    }
}

fun main(){
    val user1=User("Ciprian",50,2050,12)
    val user2=User("Casi",55,0,5000)
    val user3=User("Cosmin",1000,30,25)
    val user4=User("Claudiu",5,6,5)

    //the chain will be cash->bank->paypal

    val cashHandler:Handler = CashPayment()
    val cardHandler:Handler = CardPayment()
    val paypalHandler:Handler=PaypalPayment()

    cashHandler.setNext(cardHandler)
    cardHandler.setNext(paypalHandler)

    //let's buy some vodka
    cashHandler.handle(user1,100)
    cashHandler.handle(user2,100)
    cashHandler.handle(user3,100)
    cashHandler.handle(user4,100)
    cashHandler.handle(user3,20000)
}