package com.example.challengewave6

import java.util.*

// We use the discountCard val as nullable to validate if the vehicle has a discount
data class Vehicle(
    val plate: String,
    val type: VehicleType,
    val checkInTime: Calendar,
    val discountCard: String? = null
) {

    override fun equals(other: Any?): Boolean {

        if (other is Vehicle) {
            return this.plate == other.plate
        }
        return super.equals(other)
    }

    override fun hashCode(): Int = this.plate.hashCode()
}