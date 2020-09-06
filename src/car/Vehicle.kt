package car

abstract class Vehicle (private var cDriver: Driver? = null){

    var listOfVehicles = mutableListOf<Vehicle?>()
    private var cVehicleName: String? = this::class.java.simpleName
    private var cVehicleAgeReq: Int? = 0
    private var milesRemaining: Double? = 0.0
    private var milesDriven: Double? = 0.0

    fun driveVehicle(targetMiles: Double = 0.0, driveMiles: Double = 0.0){

        var printType: Int? = 3

        milesRemaining = calculateMilesRemaining(tMiles = targetMiles, rMiles = driveMiles)
        milesDriven = driveMiles

        when(this.isDriverAssigned()){
            true ->
               when(this) {
                   is Car -> {
                       cVehicleAgeReq = this.getAgeReq()
                       printType = when(this.checkAgeReq(driverAge = cDriver!!.age)){
                          true ->  {1}
                          false -> {2}
                       }
                   }
                   is MilitaryTank -> {
                       cVehicleAgeReq = this.getAgeReq()
                       printType = when(this.checkAgeReq(driverAge = cDriver!!.age)){
                           true ->  {1}
                           false -> {2}
                       }
               }
           }
        }
        printVehicleAction(printType)
    }

    /** ADD A VEHICLE TO THE LIST OF VEHICLES  */
    open fun addVehicle(vehicle: Vehicle?){
        listOfVehicles.add(vehicle)
    }

    /** ADD DRIVER TO VEHICLE */
    fun addToDriversSeat(driver: Driver){
        cDriver = driver
    }

    /** Calculate remaining MILES to DRIVE */
    private fun calculateMilesRemaining(tMiles: Double, rMiles: Double): Double{
        return (tMiles - rMiles)
    }

    /** CHECK IF there is a DRIVER assigned to the selected VEHICLE */
    private fun isDriverAssigned(): Boolean {
        return when(cDriver != null) {
            true -> { true }
            false -> { false }
        }
    }

    private fun printVehicleAction(printType: Int?){
        when(printType){
            1 -> {
                println("${cDriver?.name} drove $milesDriven miles - $milesRemaining miles to go")
            }
            2 -> {
                println("$cVehicleName - ${cDriver?.name} is ${cDriver?.age}, but must be $cVehicleAgeReq or older to drive this vehicle")
            }
            3 -> {
                println("$cVehicleName didn't drive - there’s no driver!")
            }
        }
    }

}

class MilitaryTank: Vehicle(){

    /** AGE REQUIREMENT for the MILITARY TANK */
    private val ageReq = 25

    /** Check if DRIVERS AGE is EQUAL to ageReq or ABOVE */
    fun checkAgeReq(driverAge: Int): Boolean{
        return (driverAge >= ageReq)
    }

    fun getAgeReq(): Int {
        return ageReq
    }

}

class Car: Vehicle(){

    /** AGE REQUIREMENT for the MILITARY TANK */
    private val ageReq = 18

    /** Check if DRIVERS AGE is EQUAL to ageReq or ABOVE */
    fun checkAgeReq(driverAge: Int): Boolean{
        return (driverAge >= ageReq)
    }

    fun getAgeReq(): Int {
        return ageReq
    }
}
