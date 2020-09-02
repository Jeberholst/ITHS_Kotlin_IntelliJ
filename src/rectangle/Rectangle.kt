package rectangle

import java.awt.Point

data class Rectangle(
        var width: Double = 0.0,
        var height: Double = 0.0,
        var xy: Point = Point(0,0)) {

    //TODO NOOOOOOT DONE

//    Lägg till en metod checkCollision i Rectangle-klassen som tittar på två rektanglar om det finns överlapp.
//    Instansvariablerna x och y refererar till övre vänstra hörnet på en rektangel.


    fun calculateArea(): Double{
        return (width * height)
    }

    fun calculatePerimeter(): Double{
        return (width * 2) + (height * 2)
    }

    fun checkCollision(rectangle1: Rectangle, rectangle2: Rectangle): Boolean {

        //TODO GÖRA KLART... SNYGGA TILL

        var rec1Xend = rectangle1.xy.x + rectangle1.width
        var rec2Xstart = rectangle2.xy.x

        var rec2Xend = rectangle2.xy.x + rectangle2.width
        var rec1Ystart = rectangle1.xy.y
        var rec1Yend = rectangle1.xy.y + rectangle1.height
        var rec2Ystart = rectangle2.xy.y
        var rec2Yend = rectangle2.xy.y + rectangle2.height


        if(rec1Xend >= rec2Xstart || rec2Xend >= rec2Xstart){
            println("X OVERLAP")
            return false
        }
        if(rec1Yend <= rec2Ystart || rec2Yend <= rec1Ystart){
            println("Y OVERLAP")
            return false
        }
        return true

    }

}

//        if(rectangle1.xy.x >= rectangle2.xy.x || rectangle2.xy.x >= rectangle1.xy.x){
//            println("")
//        }
//        if(rectangle1.xy.y <= rectangle2.xy.y || rectangle2.xy.y <= rectangle1.xy.y){
//            return false
//        }