package septemberEtt

import java.io.Reader

private const val menuChoice1 = "Add a book to the library"
private const val menuChoice2 = "Search for a book by name"
private const val menuChoice3 = "List all available books"
private const val menuChoice4 = "Return a book"
private const val menuChoice5 = "Quit"

//var listOfBooks = mutableListOf<Book>()
var reader: String? = ""
var cProgram = true
var book: Book? = Book()
var searchInput: String? = ""

fun main(){

    printChoices()
    addBooks()

    do {
        reader = readLine()

        when (reader!!.toInt()) {
            1 -> { addBooks() }
            2 -> {
                searchInput = "Book Nummer 2"
                println("Ange den boks namn du vill leta efter:")
                val v = searchBookByName(searchInput.toString())



            }
            3 -> { listBooks() }
            4 -> { }
            5 -> { cProgram = false }
            else -> {
                println("--- VÄNLIGEN ANGE ETT GILTIGT MENYVAL ---")
                printChoices()
            }
        }
        when (cProgram) {
            true -> {
                println("...")
            }
        }

    }while (cProgram)

}

private fun addBooks(){

    val book1 = Book(name = "Book Nummer 1", Author("Joakim", "Eberholst"), year = 1996, edition = "SECOND EDITION",available = true)
    val book2 = Book(name = "Book Nummer 2", Author("Joakim2", "Eberholst2"), year = 1997, available = true)

    val arr = arrayListOf(book1, book2)

    book!!.listBooks().apply {
        addAll(arr)
    }
    println("Books added")

}

private fun searchBookByName(bName: String): Book? {

    val b = book!!.listBooks()

    val newList = b.filter { book -> book.name == bName }
    newList.forEach {
        return it
    }

    return null
}


private fun listBooks(){

    book!!.bookList.forEach {
        println(it.toString())
        println()
    }
}

private fun printChoices(){

    val arrOfChoices = arrayListOf(
            Pair(1, menuChoice1),
            Pair(2, menuChoice2),
            Pair(3, menuChoice3),
            Pair(4, menuChoice4),
            Pair(5, menuChoice5))

    arrOfChoices.forEach {
        println("${it.first}. ${it.second}")}

}

