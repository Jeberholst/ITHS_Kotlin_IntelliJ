package dice

class Dice(
        var currentVal: Int = 0,
        var sides: Int = 0) {

    fun rollCurrentDice() {
        currentVal = (1 until sides).random()
        println(currentVal)
    }

}
