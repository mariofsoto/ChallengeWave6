package com.example.challengewave6

data class Parking(val vehicles: MutableSet<Vehicle>) {
    private val maxVehicles: Int = 20
    private var balance: Pair<Int, Int> = Pair(0, 0)

    // Before we add a new vehicle to the parking, we check the occupation
    fun addVehicle(vehicle: Vehicle): Boolean {
        return if (vehicles.size == maxVehicles) {
            onFailure()
            false
        } else {
            vehicles.add(vehicle)
            onSuccess()
            true
        }
    }

    private fun onSuccess() {
        println("Welcome to AlkeParking!")
    }

    private fun onFailure() {
        println("Sorry, the check-in failed")
    }

    // Here we check if the vehicle is in parking through the function isVehicleInParking then we pass the result to the checkOutVehicle function and
    // this functions remove the vehicle if is in parking otherwise trow an error message
    fun remove(vehicle: Vehicle) {
        var parkingSpace = ParkingSpace(vehicle)
        parkingSpace.checkOutVehicle(
            isVehicleInParking(vehicle),
            vehicle.plate,
            { price -> onCheckOutSuccess(price) }) {
            println(
                "Sorry, the check-out failed"
            )
        }
        vehicles.remove(vehicle)
    }

    private fun isVehicleInParking(vehicle: Vehicle): Boolean = vehicle in vehicles

    // Here we use a function because in this way the code is more readable
    // also this function print the fee and update the parking balance
    private fun onCheckOutSuccess(price: Int) {
        println("Your fee is ${price}. Come back soon.")
        balance = Pair(balance.first + 1, balance.second + price)
    }

    fun checkBalance() {
        println("${balance.first} vehicles have checked out and have earnings of $${balance.second}")
    }

    fun listVehicles() {
        println("Parking occupation: ${vehicles.size}")
        // We converted the Vehicles Set to list to iterate it
        vehicles.toList().forEach { vehicle -> println("plate:${vehicle.plate}") }
    }
}
