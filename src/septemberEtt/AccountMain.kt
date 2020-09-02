package septemberEtt

fun main(){

    val salaryAcc = Account(name = "Thor Salary")
    val savingAcc = Account(balance = 1000.0, name = "Thor Savings")
    var money: Double?

    savingAcc.apply {
        println(balance)
        withdraw(2000.0 )
        println(balance)
        money = savingAcc.withdraw(100.0)
        salaryAcc.deposit(money!!)
        println("Saving's balance: $balance")
    }

    println("Salary balance: ${salaryAcc.balance}")
    println(salaryAcc.toString())
    println(savingAcc.toString())

}