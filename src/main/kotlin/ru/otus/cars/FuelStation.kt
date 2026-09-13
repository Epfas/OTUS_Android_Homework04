package ru.otus.cars

class FuelStation {
    fun provideFuel(tankMouth: TankMouth, fuelType: FuelType, amount: Double)
    {
        tankMouth.refuel(fuelType, amount)
    }
}

