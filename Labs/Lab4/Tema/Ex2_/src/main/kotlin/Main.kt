import java.util.Date

interface PaymentMethod
{
    fun pay(fee:Double) : Boolean
}

class CashPayment : PaymentMethod
{
    private var availableAmount:Double

    constructor(money:Double)
    {
        availableAmount=money
    }

    override fun pay(fee: Double): Boolean {
        if(fee>availableAmount)
        {
            return false;
        }
        println("CashPayment: -$fee$")
        availableAmount -= fee;
        return true;
    }
}

class BankAccount
{
    private var availableAmount:Double
    private var cardNumber:String
    private var expirationDate:Date
    private var cvvCode:Int
    var userName:String

    constructor(money:Double,cardN:String,expDate:Date,cvv:Int,usr:String)
    {
        availableAmount=money
        cardNumber=cardN
        expirationDate=expDate
        cvvCode=cvv
        userName=usr
    }

    public fun getAvailableAmount(): Double
    {
        return availableAmount
    }

    public fun updateAmount(value: Double):Boolean
    {
        if (value < 0)
        {
            return false
        }
        availableAmount=value
        return true
    }
}

class CardPayment : PaymentMethod
{
    private var bankAccount:BankAccount

    constructor(money:Double,cardN:String,expDate:Date,cvv:Int,usr:String)
    {
        bankAccount=BankAccount(money,cardN,expDate,cvv,usr)
    }

    override fun pay(fee: Double): Boolean {
        var aux=bankAccount.getAvailableAmount()-fee
        val tmp=bankAccount.updateAmount(aux)
        if(tmp)
        {
            println("${bankAccount.userName} was charged with: $fee$, he has left ${bankAccount.getAvailableAmount()}$")
            return true;
        }

        println("${bankAccount.userName} doesn't have that much money ($fee$) , he has left ${bankAccount.getAvailableAmount()} $")
        return false
    }
}

class Ticket
{
    private var payment:PaymentMethod?
    private var number:Int
    private var movieName:String
    private var price:Double

    constructor(pay:PaymentMethod, nr:Int, movie:String, tmpPrice: Double)
    {
        payment=pay//aici aplic principiul substitutiei Liskov
        number=nr
        movieName=movie
        price=tmpPrice
    }

    fun buyTicket()
    {
        var tmp= payment?.pay(price)
        if(tmp == true)
        {
            println("The ticket was bought ( number : $number )")
            println("Have fun watching $movieName")
        }
        else
        {
            println("An error occurred while buying the ticket ( number : $number )")
            println("***** Customer says: Las ca ma uit pe net moka *****")
        }
    }

}


fun main(args: Array<String>) {
    var money1=CardPayment(5000.toDouble(),"5010830225620",Date(2022,8,30),825,"Galbeaza Ciprian")
    var money2=CardPayment(2.toDouble(),"5010830225620",Date(2022,8,30),825,"Farcas Cosmin")
    var money3=CashPayment(500.toDouble())

    var ticket1=Ticket(money1,101,"Spider-Man far from home",10.toDouble())
    var ticket2=Ticket(money2,102,"Spider-Man far from home",10.toDouble())
    var ticket3=Ticket(money3,103,"Spider-Man far from home",10.toDouble())

    println("-----------------------------------")
    ticket1.buyTicket()
    println("-----------------------------------")
    ticket2.buyTicket()
    println("-----------------------------------")
    ticket3.buyTicket()
    println("-----------------------------------")
}