package septemberEtt

fun main() {

    val per1 = Person(firstName = "Firstname1", lastName = "Lastname1", phoneNumber = "0000000001", age = 0, email = "example1@example.com")
    val per2 = Person(firstName = "Firstname2", lastName = "Lastname2", phoneNumber = "0000000002", age = 0, email = "example2@example.com")
    val per3 = Person(firstName = "Firstname3", lastName = "Lastname3", phoneNumber = "0000000003", age = 0, email = "example3@example.com")
    val per4 = Person(firstName = "Firstname4", lastName = "Lastname4", age = 0)

    val listOfPersons = mutableListOf(per1, per2, per3, per4)

    for(p in listOfPersons) {
        p.printGreeting()
            println("${p.firstName}, ${p.lastName}, ${p.phoneNumber}, ${p.age}, ${p.email}")
            println("---")
    }

}