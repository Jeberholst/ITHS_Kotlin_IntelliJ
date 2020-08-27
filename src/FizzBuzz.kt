private fun main(){

    println("Welcome to FizzBuzz!")

    for(i in 1..100){
        val str = returnDivision(i)
        println(str)
    }

}

private fun returnDivision(i: Int): String{

    val divThree =  i % 3
    val divFive=  i % 5

   // println("$i $divThree $i $divFive")

    return when{
        (divThree == 0) and (divFive == 0) -> {"FizzBuzz"}
        divThree == 0 -> "Fizz"
        divFive == 0 -> "Buzz"
        else -> i.toString()
    }


}