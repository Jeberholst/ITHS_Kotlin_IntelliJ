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

