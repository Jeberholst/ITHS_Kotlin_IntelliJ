package car

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

    /** ADD DRIVER TO VEHICLE */
    fun addDriver(driver: Driver){
        cDriver = driver
    }

    /** CHECK IF THERE IS A DRIVER ASSIGNED TO CURRENT VEHICLE */
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