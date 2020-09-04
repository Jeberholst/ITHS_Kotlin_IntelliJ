package pollythesheep

open class Person(var name: String, var age: Int)
class Student(sName: String, sAge: Int, var sGrade: String) : Person(name = sName, age = sAge)
class Teacher(sName: String, sAge: Int, var salary: Double) : Person(name = sName, age = sAge)
class Student2(person: Person, var sGrade: String)
class Teacher2(person: Person, sAge: Int, var salary: Double)