package septemberEtt

fun main(){

    val salaryAcc = Account()
    val savingAcc = Account(1000.0)
    var money: Double? = 0.0

    savingAcc.apply {
        println(balance)
        withdraw(2000.0 )
        println(balance)
        money = savingAcc.withdraw(100.0)
        salaryAcc.deposit(money!!)
    }

    println("Saving's balance: ${savingAcc.balance}")
    println("Salary balance: ${salaryAcc.balance}")

}