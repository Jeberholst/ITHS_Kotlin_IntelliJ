package car

import kotlin.text.StringBuilder

abstract class Vehicle (private var cDriver: Driver? = null){

    private var cVehicleName: String? = this::class.java.simpleName
    private var cVehicleAgeReq: Int? = 0
    private var milesRemaining: Double? = 0.0
    private var milesDriven: Double? = 0.0

    fun driveVehicle(targetMiles: Double = 0.0, driveMiles: Double = 0.0){

        var printType = VehicleActions.NO_DRIVER

        milesRemaining = calculateMilesRemaining(tMiles = targetMiles, rMiles = driveMiles)
        milesDriven = driveMiles

        when(this.isDriverAssigned()){
            true ->
               when(this) {
                   is Car -> {
                       cVehicleAgeReq = ageReq
                       printType = when(this.checkAgeReq(driverAge = cDriver!!.age)){
                          true ->  {VehicleActions.DRIVE}
                          false -> {VehicleActions.AGE_REQUIREMENT_FAIL}
                       }
                   }
                   is MilitaryTank -> {
                       cVehicleAgeReq = ageReq
                       printType = when(this.checkAgeReq(driverAge = cDriver!!.age)){
                           true ->  {VehicleActions.DRIVE}
                           false -> {VehicleActions.AGE_REQUIREMENT_FAIL}
                       }
               }
           }
        }
        println(getVehiclePrintStr(printType))
    }

    /** ADD A VEHICLE TO THE LIST OF VEHICLES  */
    open fun addVehicle(vehicleTypes: VehicleType){
        listOfVehicles.add(vehicleTypes.getVehicleType())
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

    /** BUILD (VEHICLE ACTION OR NON-ACTION)-STRING  */
    private fun getVehiclePrintStr(printType: VehicleActions): String{
        val strBuilder = StringBuilder().apply {
            when(printType){
                VehicleActions.DRIVE -> {
                    append("${cDriver?.name} drove $milesDriven miles - $milesRemaining miles to go")
                }
                VehicleActions.AGE_REQUIREMENT_FAIL -> {
                    append("$cVehicleName - ${cDriver?.name} is ${cDriver?.age}, " +
                            "but must be $cVehicleAgeReq or older to drive this vehicle")
                }
                VehicleActions.NO_DRIVER -> {
                    append("$cVehicleName didn't drive - there’s no driver!")
                }
            }
        }
        return strBuilder.toString()
    }

}


class MilitaryTank: Vehicle(){

    /** AGE REQUIREMENT for the MILITARY TANK */
    val ageReq = 25

    /** Check if DRIVERS AGE is EQUAL to ageReq or ABOVE */
    fun checkAgeReq(driverAge: Int): Boolean{
        return (driverAge >= ageReq)
    }

}

class Car: Vehicle(){

    /** AGE REQUIREMENT for the MILITARY TANK */
    val ageReq = 18

    /** Check if DRIVERS AGE is EQUAL to ageReq or ABOVE */
    fun checkAgeReq(driverAge: Int): Boolean{
        return (driverAge >= ageReq)
    }
}

/** ENUM CLASS FOR SPECIFIC PRINT-TYPES  */
enum class VehicleActions{
    DRIVE, AGE_REQUIREMENT_FAIL, NO_DRIVER
}

/** ENUM CLASS FOR AVAILABLE VEHICLE-TYPES */
enum class VehicleType{
    CAR, MILITARY_TANK;

    fun getVehicleType(): Vehicle? = when(this){
        CAR -> Car()
        MILITARY_TANK -> MilitaryTank()
    }
}