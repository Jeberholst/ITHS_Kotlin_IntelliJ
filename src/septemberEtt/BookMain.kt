package septemberEtt


private const val menuChoice1 = "Add a book to the library"
private const val menuChoice2 = "Search for a book by name"
private const val menuChoice3 = "List all available books"
private const val menuChoice4 = "Return a book"
private const val menuChoice5 = "Quit"
private const val menuInvalidInput = "! PLEASE INPUT A VALID MENU-CHOICE !"

//private const val searchBookName = "SEARCH FOR THE NAME OF THE BOOK YOU WANNA FIND:"
private const val searchError = "BOOK COULDN'T BE FOUND!"

var reader: String? = ""
var cProgram = true
var library: BookLibrary = BookLibrary()
var searchInput: String? = ""

fun main(){

    printChoices()
    library.addBooks()

    do {
        reader = readLine()

        when (reader!!.toInt()) {
            1 -> { library.addBooks()}
            2 -> {
                //TODO USER INPUT?
                searchInput = "Book Nummer 2"
//              println(searchBookName)
                println("Searching for $searchInput")

                val sBook = library.searchBookByName(searchInput.toString())

                when(sBook != null){
                    true -> { library.returnOrLoan(book = sBook) }
                    false ->{ println(searchError) }
                }
            }
            3 -> { library.listBooks() }
            4 -> {

                val listBooks = library.listBooks().filter { book -> !book.available }

                when(listBooks.count() != 0){
                    true -> {

                        listBooks.forEachIndexed { index, book ->
                            println("$index. ${book.name} [ ${book.isAvailableStr()} ]")
                        }
                        println("Enter the number before the books name to return it")
                        val readline = readLine()
                    }
                    false ->{
                        println("ALL BOOKS SEEM TO HAVE BEEN RETURNED!")
                    }
                }



            }
            5 -> { cProgram = false }
            else -> {
                println(menuInvalidInput)
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

