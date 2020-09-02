package septemberEtt

fun main(){

    val rect1 = Rectangle(width = 2.0, height = 2.0, y = 2.0, x = 3.0)
    val rect2 = Rectangle(width = 5.0, height = 9.0, y = 5.0, x = 6.0)
    val rect3 = Rectangle(width = 3.0, height = 2.0, y = 2.0, x = 3.0)

    rect1.apply {
        println(calculateArea())
        println(calculatePerimeter())
    }
    

}