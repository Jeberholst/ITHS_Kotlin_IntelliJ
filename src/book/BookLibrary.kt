package book

import kotlin.random.Random


class BookLibrary {

    private val book: Book? = Book()

    fun addBooks(){

        val book1 = Book(id = Random(10000), name = "Book Nummer 1", Author("Joakim", "Eberholst"), year = 1996, edition = "SECOND EDITION",available = false)
        val book2 = Book(id = Random(10000), name = "Book Nummer 2", Author("Joakim2", "Eberholst2"), year = 1997, available = false)
        val book3 = Book(id = Random(10000), name = "Book Nummer 3", Author("Aaa", "Eberholst3"), year = 1997, available = true)

        val arr = arrayListOf(book1, book2, book3)

        book!!.listBooks().apply {
            addAll(arr)
        }
        println("BOOKS ADDED!")

    }

    fun searchBookByName(bName: String): Book? {

        val b = book!!.listBooks()

        val newList = b.filter { book -> book.name == bName }
        newList.forEach {
            return it
        }

        return null
    }

    fun listBooksList(): MutableList<Book> = book!!.bookList

    fun listBooksFull() {
        book!!.bookList.forEach {
            println(it.toString())
            println()
        }
    }

    fun returnOrLoan(book: Book){

        var reader: String?

        when(book.available){
            true -> {
                println("${book.isAvailableStr()}, do you wanna withdraw the book for loaning? Y/N")
                reader = readLine()
                when(reader == "Y"){
                    true -> { book.loanBook(); println("HERE YOU GO, TAKE THE BOOK!")}
                    false ->  { println("YOU SELECTED NO, NOTHING HAS BEEN CHANGED.") }
                }
            }
            false ->{
                println("${book.isAvailableStr()}, do you want to return the book? Y/N")
                reader = readLine()
                when(reader == "Y"){
                    true -> { book.returnBook(); println("THE BOOK HAS BEEN RETURNED, THANK YOU!")}
                    false -> { println("YOU SELECTED NO, NOTHING HAS BEEN CHANGED.")}
                }
            }
        }
    }


}