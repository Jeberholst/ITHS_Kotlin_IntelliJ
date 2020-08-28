private const val startQuestion = "Vad vill du göra?"
private const val menuChoice1 = "Addera två tal"
private const val menuChoice2 = "Räkna bokstäver i en sträng"
private const val menuChoice3 = "Spegelvänd en sträng"
private const val menuChoice4 = "Summera alla tal i en sträng"
private const val menuChoiceEnd = "Avsluta program."

private fun main(){

    startProgram()
    var cProgram = true

    do {

        val reader: String? = readLine()

        when(reader.toString()){
            "0", "" -> { println("Dummer, tryck inte bara ENTER eller ange 0 ;)") }
            "1" -> { println(runAdditionOfTwo()) }
            "2" -> { println(runStringCharCount()) }
            "3" -> { println(runStringReversal()) }
            "4" -> { println(sumSuppliedNumbers()) }
            else -> {
                when(reader.equals("e", ignoreCase = true).not()){
                    true -> {
                        println("----INGET PROGRAM MOTSVARAR DET DU SKREV IN.. FÖRSÖK IGEN----")
                    }
                    false -> {
                        cProgram = false
                    }
                }
            }
        }
        when(cProgram){
            true -> {
                println("...")
                startProgram()
            }
        }

    } while (reader.equals("e", ignoreCase = true).not())

}

private fun runAdditionOfTwo(): String{
    println("Ange första talet: "); val first = Integer.parseInt(readLine())
    println("Ange andra talet: "); val second = Integer.parseInt(readLine())
    return "Summan är:" + (first + second).toString()
}

private fun runStringCharCount(): String {
    println("Ange en bokstavssträng: "); val charStr = readLine()?.length ?: 0
    return when {
        charStr != 0 -> { "Längden är: $charStr" }
        else -> { "KAN INTE BERÄKNA ETT TOMT VÄRDE" }
    }
}

private fun runStringReversal(): String {
    println("Ange en bokstavssträng du vill spegelvända: "); val charStrRev = readLine()?.reversed() ?: 0
    return when {
        charStrRev != 0 -> { "Spegelvänd sträng: $charStrRev" }
        else -> { "FÖRSÖKTE SPEGELVÄNDA INGENTING SÅ HÄR BLEV DET:" }
    }
}
private fun sumSuppliedNumbers(): String {
    println("Ange alla nummer du vill summera:"); val charStrRev = readLine() ?: 0
    var v = 0
    for(s in charStrRev.toString()){
         v += Character.getNumericValue(s)
    }
    return v.toString()
}

private fun startProgram(){

    val arrOfChoices = arrayListOf(
            Pair(1, menuChoice1),
            Pair(2, menuChoice2),
            Pair(3, menuChoice3),
            Pair(4, menuChoice4))

    val endChoice= Pair("E/e", menuChoiceEnd)

    println(startQuestion)
    arrOfChoices.forEach {
        println("${it.first}. ${it.second}")
    }
    println("${endChoice.first}. ${endChoice.second}")

}