package account

class Account(
        var balance: Double = 0.0,
        var name: String? = "") {

    fun withdraw(amount : Double) : Double {
        when(checkBalance(amount)){
            true -> {
                balance -= amount
                return amount
            }
        }
        return 0.0
    }

    fun deposit(amount: Double) {
        balance += amount
    }

    override fun toString(): String {
       return "${name?.capitalize()}, your current balance is $balance."
    }

    private fun checkBalance(amount: Double): Boolean{
        return when(balance >= amount && amount > 0){
            true -> true
            else -> false
        }
    }

}