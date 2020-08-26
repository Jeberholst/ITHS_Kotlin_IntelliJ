private fun main(){

    println("Welcome to FizzBuzz!")
    println("Please choose a difficulty below by typing the corresponding letter (E = EASY, M = MEDIUM, H = HARD):")
    val reader = readLine()

    val easyRange = (1..10)
    val mediumRange = (1..100)
    val hardRange = (1..1000)

    when(reader){
        "E" -> {
            printChoosenDifficulty("EASY")
            printNumberRange(easyRange.last)
            doLoopUntilCorrectEntry(easyRange.random())
         }
        "M" -> {
            printChoosenDifficulty("MEDIUM")
            printNumberRange(mediumRange.last)
            doLoopUntilCorrectEntry(mediumRange.random())
        }
        "H" -> {
            printChoosenDifficulty("HARD")
            printNumberRange(hardRange.last)
            doLoopUntilCorrectEntry(hardRange.random())
        }
        else -> {
            println("CHOOSEN DIFFICULTY IS NON EXISTING, PLEASE SELECT E, M or H")
            //main() //TODO RESTART?
        }
    }

}

private fun doLoopUntilCorrectEntry(randomRange: Int){

    var reader2: String?
    var tryCounter = 0

   // println(randomRange)

    do {
        reader2 = readLine()
        tryCounter += 1

        when{
            reader2!!.toInt() > randomRange -> {
                println("TRY AGAIN! NUMBER IS LOWER")}
            reader2.toInt() < randomRange -> {
                println("TRY AGAIN! NUMBER IS HIGHER")
            }
        }
        when (reader2?.toInt() == randomRange){
            true -> {
                println("CORRECT! GOOD WORK!! AMOUNT OF TRIES: $tryCounter")
            }
        }
    }while (reader2?.toInt() != randomRange)

}

private fun printChoosenDifficulty(difficulty: String){
    println("You have choosen the $difficulty difficulty")
}

private fun printNumberRange(maxNum: Int){
    println("PLEASE GUESS A NUMBER BETWEEN 1 to $maxNum")
}