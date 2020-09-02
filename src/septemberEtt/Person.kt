package septemberEtt

data class Person (
        var firstName: String = "Firstname",
    var lastName: String,
    var email: String = "empty@example.com",
    var phoneNumber: String = "XXXXXXXXXX",
    var age: Int = 0) {

    fun printGreeting() {
        println("Hello! My name is $firstName")
    }

}