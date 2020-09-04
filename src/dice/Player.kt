package dice

class Player (
        var name: String = "",
        var points: Int = 0,
        var diceList: MutableList<Dice> = mutableListOf())
{
    var playersList: MutableList<Player> = mutableListOf()

    fun rollAllDices(){
        diceList.forEach {
            it.rollCurrentDice()
        }
    }

    fun sumOfDices(): Int{
        return diceList.sumBy { dice -> dice.currentVal }
    }
    
    fun increaseScore(){
        points ++
    }
             
    fun addDicesToPlayer(amountOfDices: Int, amountOfSides: Int){
         for (i in 0 until amountOfDices){
             val newDice = Dice(sides = amountOfSides)
             diceList.add(i, newDice)
         }
    }

}