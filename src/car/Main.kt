package car

fun main(){

    val vehicle = object : Vehicle(){}

    val d1 =  Driver(name = "Emilia", age = 17)
    val d2 =  Driver(name = "Niklas", age = 21)

    vehicle.addVehicle(Car())
    vehicle.addVehicle(MilitaryTank())

    val v1 : Vehicle = vehicle.listOfVehicles[0]
    val v2 : Vehicle = vehicle.listOfVehicles[1]

     v1.drive()
     v2.drive()

     v1.addDriver(d1)
     v1.drive()

     v1.addDriver(d2)
     v2.addDriver(d2)

     v2.drive()

     val tankMan = Driver(name = "TankMan", age = 300)
     v2.addDriver(tankMan)

     v1.drive(targetMiles = 100.0, drivenMiles = 10.0) // Prints “Car drove 10 miles - 90 miles to go”
     v2.drive(targetMiles = 2000.0, drivenMiles = 5.0) // Prints “MilitaryTank drove 5 miles - 1995 miles to go”
     v1.drive(targetMiles = 90.0, drivenMiles = 10.0)  // Prints “Car drove 10 miles - 80 miles to go”
     v2.drive(targetMiles = 1995.0, drivenMiles = 5.0) // Prints “MilitaryTank drove 5 miles - 1990 miles to go”

}

//ADD A DRIVER TO THE VEHICLE
abstract class Vehicle (
        var cDriver: Driver? = null){

    var listOfVehicles = mutableListOf<Vehicle>()

    fun addVehicle(vehicle: Vehicle){
        listOfVehicles.add(vehicle)
    }

    fun drive(targetMiles: Double = 0.0, drivenMiles: Double = 0.0){

        when(this){
            is Car -> {
                if(isDriverAssigned()){
                    if(this.checkAgeReq(driverAge = cDriver!!.age)){
                        println("Car drove $drivenMiles miles - ${calculateMilesRemaining(targetMiles, drivenMiles)} miles to go")
                    }else{
                        println("Car didn't drive - ${cDriver?.name} is ${cDriver?.age}, but must be 18 or older to drive")
                    }
                }else{
                     println("Car didn’t drive - there’s no driver!")
                }
            }
            is MilitaryTank -> {
                if(isDriverAssigned()){
                    if(this.checkAgeReq(driverAge = cDriver!!.age)){
                        println("MilitaryTank drove $drivenMiles miles - ${calculateMilesRemaining(targetMiles, drivenMiles)} miles to go")
                    }else{
                        println("MilitaryTank didn't drive - ${cDriver?.name} is ${cDriver?.age}, but must be 25 or older to drive")
                    }
                }else{
                    println("MilitaryTank didn’t drive - there’s no driver!")
                }
            }
            else -> {
                println("INVALID VEHICLE")
            }
        }
    }

    private fun calculateMilesRemaining(tMiles: Double, rMiles: Double): Double{
          return (tMiles - rMiles)
    }

    fun addDriver(driver: Driver){
        cDriver = driver
    }

    //CHECK IF THERE IS A DRIVER ASSIGNED
    fun isDriverAssigned(): Boolean {
        return when(cDriver != null) {
            true -> { true }
            false -> { false }
        }
    }
}
class MilitaryTank: Vehicle(){

    private val ageReq = 25

    fun checkAgeReq(driverAge: Int): Boolean{
        return (driverAge >= ageReq)
    }

}
class Car: Vehicle(){

    private val ageReq = 18

    fun checkAgeReq(driverAge: Int): Boolean{
        return (driverAge >= ageReq)
    }
}

open class Driver(var name: String, var age: Int) {}
