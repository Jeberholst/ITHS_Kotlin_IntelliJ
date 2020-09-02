package septemberEtt

import java.awt.Point

fun main(){

    val rect = Rectangle()

    val rect1 = Rectangle(width = 3.0, height = 2.0, xy = Point(2,5))
//    val rect2 = Rectangle(width = 5.0, height = 9.0, xy = Point(0,0))
    val rect3 = Rectangle(width = 5.0, height = 6.0, xy = Point(4,5))

    rect1.apply {
//        println(calculateArea())
//        println(calculatePerimeter())
    }


//    rect.checkCollision(rect1, rect3)
    when(rect.checkCollision(rect1, rect3)){
        true -> {
            println("COLLISION")
        }
        false -> {
            println("NO COLLISION")
        }
    }


}