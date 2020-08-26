
fun main(){

    printAddEntry(question = "Vänligen ange ett personnummer i format SSYYMMDDXXXX eller SSSSYYMMDDXXXX")
    val reader = readLine()
    var pNumber = ""
    var isError = false

    when(reader?.length){
        10 -> { pNumber = reader }
        12 -> { pNumber = reader.substring(2, 12) }
        else ->{ printErrorEntry(); isError = true }
    }

    when(isError){
        false -> {
            when(isCorrectPersonalIdNumber(pNumber)){
                true ->{ printPerIDnumCorrect() }
                false ->{ printPerIDnumIncorrect() }
            }
        }
        true -> {
            main()
        }
    }

}

fun isCorrectPersonalIdNumber(pNumber: String): Boolean{

    val calculationFormula = arrayListOf(2,1,2,1,2,1,2,1,2,1)
    val finalCalcArr = arrayListOf<Int>()

    calculationFormula.forEachIndexed { index, i ->

        val cNum: Int = Character.getNumericValue(pNumber[index])
        val cFormulaNum = calculationFormula[i]

        val calculatedNum = cNum * cFormulaNum

        if (calculatedNum >= 10) {
            finalCalcArr.add(Character.getNumericValue(calculatedNum.toString().toCharArray()[0].toInt()))
            finalCalcArr.add(Character.getNumericValue(calculatedNum.toString().toCharArray()[1].toInt()))
        } else {
            finalCalcArr.add(calculatedNum)
        }
    }

    return when(finalCalcArr.sum() % 10) {
        1-> {false}
        0 -> {true}
        else -> { false }
    }

}


fun printAddEntry(question: String){
    println("$question:")
}
fun printErrorEntry (){
    println("FEL ANTAL NUMMER ANGIVNA, FÖRSÖK IGEN!")
}
fun printPerIDnumCorrect (){
    println("PERSONNUMMER ÄR GILTIGT")
}
fun printPerIDnumIncorrect (){
    println("PERSONNUMMER ÄR OGILTIGT")
}