private fun main(){

    println("Welcome to FizzBuzz!")
    for(i in 1..100){
        println(returnDivisible(i))
    }
}

private fun returnDivisible(i: Int): String {

    val divThree =  i % 3
    val divFive=  i % 5

    return when{
        (divThree == 0) and (divFive == 0) -> { "FizzBuzz" }
        divThree == 0 -> { "Fizz" }
        divFive == 0 -> { "Buzz" }
        else -> i.toString()
    }

}