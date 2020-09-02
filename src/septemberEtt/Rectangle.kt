package septemberEtt

data class Rectangle (
    var width: Double = 0.0,
    var height: Double = 0.0,
    var x: Double = 0.0,
    var y: Double = 0.0) {

    fun calculateArea(): Double{
        return (width * height)
    }

    fun calculatePerimeter(): Double{
        return (width * 2) + (height * 2)
    }

}