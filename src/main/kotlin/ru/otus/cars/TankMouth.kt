package ru.otus.cars

interface TankMouth {
    fun refuel(fuelType: FuelType, amount: Double)
    fun isFuelCompatible(fuelType: FuelType): Boolean
}