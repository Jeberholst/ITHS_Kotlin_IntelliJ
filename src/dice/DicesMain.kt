package dice

//    val p1 = Player(name = "Jocke")
//    val p2 = Player(name = "Alpha")
//    val p3 = Player(name = "Beta")
//    val listOfAddedPlayers = mutableListOf(p1, p2, p3)
//    players.playersList.addAll(listOfAddedPlayers)

const val strWelcome = "Welcome!"
const val strAskAmountOfPlayers = "Please enter AMOUNT of PLAYERS"
const val strAskDicesAmount = "Please enter AMOUNT of DICES per PLAYER:"
const val strAskDicesSides = "Please enter AMOUNT of SIDES for each DICE:"
const val strCorrectGuess = "--> Correct guess. Increasing your points by 1!"
const val strIncorrectGuess = "--> Incorrect guess. No points for you!"


val players: Player = Player()
var amountOfDicesPerPlayer = 0
var amountOfDiceSides = 0
var amountOfPlayers = 2


fun main () {

    println(strWelcome)
    println(strAskAmountOfPlayers)
    var readL = readLine(); amountOfPlayers = readL?.toInt() ?: 1
    println(strAskDicesAmount)
    readL = readLine(); amountOfDicesPerPlayer = readL?.toInt() ?: 1
    println(strAskDicesSides)
    readL = readLine(); amountOfDiceSides = readL?.toInt() ?: 1

    addNewPlayersToList()

    val currentPlayers = players.playersList
    currentPlayers.forEach {
        it.addDicesToPlayer(amountOfDices = amountOfDicesPerPlayer, amountOfSides = amountOfDiceSides)
    }

    for (i in 1 .. 4){

        println("Starting round $i ...")

        currentPlayers.forEach { player ->
            println("Guess your next roll ${player.name}! (if no guess is supplied you guess will be defaulted to 100000)")
            val rLine = readLine() ?: 100000

            println("Rolling dices..")
            player.rollAllDices()
            println("You rolled in total: ${player.sumOfDices()}")

            when(player.sumOfDices() == rLine){
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

fun addNewPlayersToList(){

    for (p in 0 until amountOfPlayers){
        println("Supply a player name:")
        val rPlayerName = readLine()
        val newPlayer = Player(name = rPlayerName.toString())
        players.playersList.add(newPlayer)
    }

}