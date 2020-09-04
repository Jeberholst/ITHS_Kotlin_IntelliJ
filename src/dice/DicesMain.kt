package dice


val players: Player = Player()
var amountOfDicesPerPlayer = 0
var amountOfDiceSides = 0
var amountOfPlayers = 2

fun main () {

    println("Welcome!")
    println("Please enter AMOUNT of DICES per PLAYER:")
    var readL = readLine(); amountOfDicesPerPlayer = readL?.toInt() ?: 1
    println("Please enter AMOUNT of SIDES for each DICE:")
    readL = readLine(); amountOfDiceSides = readL?.toInt() ?: 1
    //addNewPlayersToList()

    val p1 = Player(name = "Jocke")
    val p2 = Player(name = "Alpha")
    val p3 = Player(name = "Beta")
    val listOfAddedPlayers = mutableListOf(p1, p2, p3)
    players.playersList.addAll(listOfAddedPlayers)
    val currentPlayers = players.playersList
    currentPlayers.forEach {
        it.addDicesToPlayer(amountOfDices = amountOfDicesPerPlayer, amountOfSides = amountOfDiceSides)
    }

    for (i in 1 .. 4){

        println("Starting round $i ...")

        currentPlayers.forEach { player ->
            println("Guess your next roll ${player.name}")
            val rLine = readLine()

            println("Rolling dices..")
            player.rollAllDices()
            println("You rolled in total: ${player.sumOfDices()}")

            when(player.sumOfDices() == rLine?.toInt()){
                true -> {
                    println("--> Correct guess. Increasing points by 1!")
                    player.increaseScore()
                }
                false -> {
                    println("--> Incorrect guess. No points for you!")
                }
            }

        }
    }

    println("Results..")
    currentPlayers.forEach { cPlayer ->
        println("${cPlayer.name} : ${cPlayer.points}")
    }

    currentPlayers.sortBy { cPlayer -> cPlayer.points }
    currentPlayers.forEach { cPlayer ->
        println("${cPlayer.name} : ${cPlayer.points}")
    }
}

fun addNewPlayersToList(){

    for (p in 0 until amountOfPlayers){
        println("Supply a player name")
        var readAddPlayer = readLine()
        var newPlayer = Player(name = readAddPlayer.toString())
        newPlayer.addDicesToPlayer(amountOfDices = amountOfDicesPerPlayer, amountOfSides =  amountOfDiceSides)
        players.playersList.add(newPlayer)
    }

}