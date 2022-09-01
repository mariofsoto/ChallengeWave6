package com.example.challengewave6

import java.util.*

fun main() {
    // Ej 1: ¿Por qué se define vehicles como un Set?
    // Por definición un Set es utilizado para guardar objetos de un mismo tipo y es mejor para saber si un valor se encuentra o no en el conjunto dado.
    // Ya que en el presente Challenge tenemos que realizar consultas sobre el mismo es que se define un Set y no otro tipo de colección

    // Ej 2: ¿Puede cambiar el tipo de vehículo en el tiempo? ¿Debe definirse como variable o como constante en com.example.challengewave6.Vehicle?
    // No puede cambiar en el tiempo por lo tanto asignamos un val porque una placa va a corresponder siempre al mismo vehiculo

    // Ej 3: ¿Dónde deben agregarse las propiedades, en com.example.challengewave6.ParkingSpace, com.example.challengewave6.Vehicle o en ambos?
    // com.example.challengewave6.Vehicle
    // ¿Cómo indicamos que un tipo de datos puede adquirir esta característica en Kotlin?
    // Agregamos un signo de interrogación al final del tipo de variable

    // Here we created the vehicles
    val car = Vehicle("AA111AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val moto = Vehicle("BB222BB", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val minibus = Vehicle("CC333CC", VehicleType.MINIBUS, Calendar.getInstance())
    val bus = Vehicle("DD444DD", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val bus2 = Vehicle("DO425DD", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val moto2 = Vehicle("BA232BD", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val minibus2 = Vehicle("CC332AC", VehicleType.MINIBUS, Calendar.getInstance())
    val bus3 = Vehicle("DX484DD", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val moto3 = Vehicle("BA212BB", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val minibus3 = Vehicle("FG392CC", VehicleType.MINIBUS, Calendar.getInstance())
    val bus4 = Vehicle("DD892DD", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val moto4 = Vehicle("BK223CB", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val minibus4 = Vehicle("CC048AC", VehicleType.MINIBUS, Calendar.getInstance())
    val bus5 = Vehicle("DD478LD", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val moto5 = Vehicle("BA278PB", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val minibus5 = Vehicle("CN033CC", VehicleType.MINIBUS, Calendar.getInstance())
    val bus6 = Vehicle("SD431DW", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val bus7 = Vehicle("DA423CZ", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_002")


    // Now we add the vehicles to the parking list
    val parking = Parking(
        mutableSetOf(
            car,
            moto,
            minibus,
            bus,
            bus2,
            moto2,
            minibus2,
            bus3,
            moto3,
            minibus3,
            bus4,
            moto4,
            minibus4,
            bus5,
            moto5,
            minibus5,
            bus6,
            bus7
        )
    )

    // We created a second car with an existing plate to check that it won't be added
    val car2 = Vehicle("AA111AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val isCar2Inserted = parking.vehicles.add(car2)

    // Here we check the parking list with above conditions
    println(parking.vehicles.contains(car))
    println(parking.vehicles.contains(moto))
    println(parking.vehicles.contains(minibus))
    println(parking.vehicles.contains(bus))
    println(isCar2Inserted)

    // Here we created a custom time to check the discount card feature
    var hora = Calendar.getInstance()
    hora.set(Calendar.HOUR, 7)
    hora.set(Calendar.MINUTE, 3)

    // We created two cars, one with a discount card and one without
    val car3 = Vehicle("AA111BA", VehicleType.CAR, hora, "DISCOUNT_CARD_003")
    val car4 = Vehicle("AA119AA", VehicleType.CAR, hora)
    parking.addVehicle(car3)
    parking.addVehicle(car4)

    // Here we check the full occupation feature
    val car10 = Vehicle("YA119AA", VehicleType.CAR, hora)
    parking.addVehicle(car10)

    // We removed the cars to check the discount
    parking.remove(car3)
    parking.remove(car4)

    // Here we check the OnError status of remove feature
    val car5 = Vehicle("AA123BA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_003")
    parking.remove(car5)

    // Check the parking total balance
    parking.checkBalance()

    // Check the parking occupation
    parking.listVehicles()
}