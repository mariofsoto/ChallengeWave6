package com.example.challengewave6

import java.util.*
import kotlin.math.ceil

data class ParkingSpace(var vehicle: Vehicle) {
    private val MINUTES_IN_MILISECONDS = 60000
    private val EXCEEDED_PRICE_TIME = 5
    private val EXCEEDED_TIME = 15
    private val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS

    // Here we use isVehicleInParking to control the function behavior
    fun checkOutVehicle(
        isVehicleInParking: Boolean,
        plate: String,
        OnSuccess: (Int) -> Unit,
        OnError: () -> Unit
    ) {
        if (isVehicleInParking) {
            OnSuccess(calculateFee(vehicle.type, parkedTime.toInt()))
        } else {
            OnError()
        }
    }

    // We calculated the total fee taking a base price from the vehicle type and then if correspond we add the exceeded time to the fee
    private fun calculateFee(vehicleType: VehicleType, parkedTime: Int): Int {
        var totalPrice = vehicleType.price
        if (parkedTime > 120) {
            val minutesRemaining = parkedTime - 120
            totalPrice += (ceil(minutesRemaining.toDouble() / EXCEEDED_TIME) * EXCEEDED_PRICE_TIME).toInt()
        }

        // We use the let scope function to implement the null safety
        vehicle.discountCard?.let { totalPrice = (totalPrice * 0.85).toInt() }
        return totalPrice
    }
}