package pollythesheep

var listOfPersons = mutableListOf<Person>()

fun main() {

    val s1 = Person("Student", 15)
    val t1 = Teacher("Teacher", 15, salary = 24000.00)

    listOfPersons.apply {
        add(s1)
        add(t1)
    }

    listOfPersons.forEach {
        println(it.name)
    }
}