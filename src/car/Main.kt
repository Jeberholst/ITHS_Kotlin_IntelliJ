package car

var listOfVehicles = mutableListOf<Vehicle?>()

fun main(){

     /** CREATE CLASS AS A NEW INSTANCE-OBJECT */
     val vehicle = object : Vehicle(){}

     /** CREATE 2 DRIVERS  */
     val d1 =  Driver(name = "Emil I. Berg", age = 17)
     val d2 =  Driver(name = "Niko Klaus", age = 21)

     /** ADD 2 TYPES OF VEHICLES TO THE VEHICLE LIST  */
     vehicle.addVehicle(vehicleTypes = VehicleType.CAR)
     vehicle.addVehicle(vehicleTypes = VehicleType.MILITARY_TANK)

     /** PUT THE 2 VEHICLES IN 2 FINAL VARIABLES -> FROM LIST-INDEX  */
     val v1 : Vehicle = listOfVehicles[0]!!
     val v2 : Vehicle = listOfVehicles[1]!!

     /** DRIVE VEHICLE 1  */
     v1.driveVehicle()
     /** DRIVE VEHICLE 2  */
     v2.driveVehicle()

     /** ADD DRIVER TO VEHICLE */
     v1.addToDriversSeat(driver = d1)
     /** DRIVE VEHICLE 1  */
     v1.driveVehicle()

     /** ADD DRIVER d2 to VEHICLE 1 */
     v1.addToDriversSeat(driver = d2)
     /** ADD DRIVER d2 to VEHICLE 2 */
     v2.addToDriversSeat(driver = d2)

     /** DRIVE VEHICLE 2  */
     v2.driveVehicle()

     /** CREATE 1 NEW DRIVER  */
     val tankMan = Driver(name = "TankMan", age = 300)
     /** ADD DRIVER tankMan TO VEHICLE 2 */
     v2.addToDriversSeat(driver = tankMan)

     /** DRIVE BOTH VEHICLES TWICE, WITH PARAMETERS FOR AMOUNT OF MILES AND ALREADY DRIVEN MILES */
     v1.driveVehicle(targetMiles = 100.0, driveMiles = 10.0)
     v2.driveVehicle(targetMiles = 2000.0, driveMiles = 5.0)
     v1.driveVehicle(targetMiles = 90.0, driveMiles = 10.0)
     v2.driveVehicle(targetMiles = 1995.0, driveMiles = 5.0)

}


