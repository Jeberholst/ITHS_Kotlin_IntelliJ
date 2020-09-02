package septemberEtt

import java.lang.StringBuilder

class Book(
        var name: String = "",
        var author: Author? = Author(surName = "", lastName = ""),
        var year: Int = 0,
        var edition: String = "FIRST EDITION",
        var available: Boolean = true) {

    var bookList: MutableList<Book> = mutableListOf()

    fun loanBook(){
        when(isAvailable()){
            true -> {
                available = false
            }
        }
    }

    fun isAvailable(): Boolean {
        return available
    }

    fun isAvailableStr(): String {
        return when(available){
            true -> "AVAILABLE"
            false -> "NOT AVAILABLE"
        }
    }

    fun returnBook(){
        when(isAvailable()){
            false -> {
                available = true
            }
        }
    }

    fun addBook(book: Book){

    }

    fun listBooks(): MutableList<Book> {
        return bookList
    }

    override fun toString(): String {
        val strBuilder = StringBuilder().apply {
            append("Book: $name")
            appendLine()
            append("Author: ${author?.surName} ${author?.lastName}")
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


class Author(
        var surName: String,
        var lastName: String){

        fun fullName(): String{
            return  "$surName + $lastName"
        }

}