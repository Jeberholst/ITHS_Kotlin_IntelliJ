package dice

import java.lang.StringBuilder


const val strWelcome = "Welcome!"
const val strAskAmountOfPlayers = "Please enter AMOUNT of PLAYERS"
const val strAskDicesAmount = "Please enter AMOUNT of DICES per PLAYER:"
const val strAskDicesSides = "Please enter AMOUNT of SIDES for each DICE:"
const val strCorrectGuess = "--> Correct guess. Increasing your points by 1!"
const val strIncorrectGuess = "--> Incorrect guess. No points for you!"

val players: Player = Player()
var amountOfDicesPerPlayer = 0
var amountOfDiceSides = 0
var amountOfPlayers = 0

fun main () {

    val currentPlayers = players.playersList

    println(strWelcome)
    println(strAskAmountOfPlayers)
    var readL: String? = readLine(); amountOfPlayers = readL?.toInt() ?: 1
    println(strAskDicesAmount)
    readL = readLine(); amountOfDicesPerPlayer = readL?.toInt() ?: 1
    println(strAskDicesSides)
    readL = readLine(); amountOfDiceSides = readL?.toInt() ?: 1

    addPlayersToListFromInput()
//  addTestGroup()

    currentPlayers.forEach {
        it.addDicesToPlayer(amountOfDices = amountOfDicesPerPlayer, amountOfSides = amountOfDiceSides)
    }

    for (i in 1 .. 5){

        println()
        println("Starting round $i ...")

        currentPlayers.forEach { player ->
            println("Guess your next roll ${player.name}!")
            val rLine = readLine()
//          val rLine = player.guesses[i-1]
            println("Rolling dices..")
            player.rollAllDices()

            val strBuilder = StringBuilder()
            println(player.diceList.forEach {
                strBuilder.apply {
                    append("${it.currentVal}, ")
                }
            })

            println("Your dice-rolls: $strBuilder")
            println("You guessed $rLine")
            println("You rolled in total: ${player.sumOfDices()}")

            when(player.sumOfDices() == rLine?.toInt()){
                true -> {
                    println(strCorrectGuess)
                    player.increaseScore()
                }
                false -> {
                    println(strIncorrectGuess)
                }
            }

        }
    }

    println("Results..")
    currentPlayers.forEach { cPlayer ->
        println("${cPlayer.name} : ${cPlayer.points}")
    }

}

fun addPlayersToListFromInput(){

    for (p in 0 until amountOfPlayers){
        println("Supply a player name:")
        val rPlayerName = readLine()
        val newPlayer = Player(name = rPlayerName.toString())
        players.playersList.add(newPlayer)
    }

}

fun addTestGroup(){
    val p1 = Player(name = "Jocke", guesses = mutableListOf(1,3,2,3,5))
    val p2 = Player(name = "Alpha", guesses = mutableListOf(1,2,4,2,6))
    val p3 = Player(name = "Beta", guesses = arrayListOf(1,2,1,3,2))

    val listOfAddedPlayers = mutableListOf(p1, p2, p3)
    players.playersList.addAll(listOfAddedPlayers)
}
