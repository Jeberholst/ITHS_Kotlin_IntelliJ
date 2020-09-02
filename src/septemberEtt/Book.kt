package septemberEtt

import java.lang.StringBuilder

class Book(
        var name: String = "",
        var author: Author? = Author(surName = "", lastName = ""),
        var year: Int = 0,
        var edition: String = "FIRST EDITION",
        var available: Boolean = true) {

    var bookList: MutableList<Book> = mutableListOf()


    private fun isAvailable(): Boolean {
        return available
    }

    private fun isAvailableStr(): String {
        return when(available){
            true -> "AVAILABLE"
            false -> "NOT AVAILABLE"
        }
    }

    fun returnOrLoan(){

        var reader: String? = ""

        when(isAvailable()){
            true -> {
                println("${isAvailableStr()}, do you wanna withdraw the book for loaning? Y/N")
                reader = readLine()
                when(reader == "Y"){
                    true -> { loanBook(); println("HERE YOU GO, TAKE THE BOOK!")}
                    false ->  { println("YOU SELECTED NO, NOTHING HAS BEEN CHANGED.") }
                }
            }
            false ->{
                println("${isAvailableStr()}, do you want to return the book? Y/N")
                reader = readLine()
                when(reader == "Y"){
                    true -> { returnBook(); println("THE BOOK HAS BEEN RETURNED, THANK YOU!")}
                    false -> { println("YOU SELECTED NO, NOTHING HAS BEEN CHANGED.")}
                }
            }
        }
    }

    private fun loanBook(){
        when(isAvailable()){
            true -> {
                available = false
            }
        }
    }

    private fun returnBook(){
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

class Author(var surName: String, var lastName: String){
    fun fullName(): String{
        return  "$surName + $lastName"
    }
}