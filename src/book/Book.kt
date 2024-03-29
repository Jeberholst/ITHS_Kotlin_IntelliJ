package book

import java.lang.StringBuilder
import kotlin.random.Random

class Book(
        var id: Random = Random(0),
        var name: String = "",
        var author: Author? = Author(surName = "", lastName = ""),
        var year: Int = 0,
        var edition: String = "FIRST EDITION",
        var available: Boolean = true) {

    var bookList: MutableList<Book> = mutableListOf()

     fun isAvailable(): Boolean {
        return available
    }

    fun isAvailableStr(): String {
        return when(available){
            true -> "AVAILABLE"
            false -> "NOT AVAILABLE"
        }
    }

    fun loanBook(){
        when(isAvailable()){
            true -> {
                available = false
            }
        }
    }

    fun returnBook(){
        when(isAvailable()){
            false -> {
                available = true
            }
        }
    }

    //TODO
//    fun addBook(book: Book){
//
//    }

    fun listBooks(): MutableList<Book> {
        return bookList
    }

    override fun toString(): String {
        val strBuilder = StringBuilder().apply {
            append("Book: $name")
            appendLine()
            append("Author: ${author?.fullName()}")
            appendLine()
            append("Year: $year")
            appendLine()
            append("Edition: $edition")
            appendLine()
            append("Available: ${isAvailableStr()}")
        }
        return strBuilder.toString()
    }
}

class Author(var surName: String, var lastName: String){
    fun fullName(): String{
        return  "$surName, $lastName"
    }
}