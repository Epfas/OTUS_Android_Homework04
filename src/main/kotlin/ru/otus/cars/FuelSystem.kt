package ru.otus.cars

class FuelSystemException(message: String) : Exception(message)

enum class FuelType
{PETROL, DIESEL, LPG, CNG}

class FuelSystem(
    val fuelType: FuelType = FuelType.PETROL,
    capacity: Double = 60.0
) {
    private val fuelTank = FuelTank(capacity)
    fun getFuelLevel(): Double = fuelTank.level
    fun getCapacity(): Double = fuelTank.capacity

    fun refuel(amount: Double)
    {
        if (amount <= 0)
            throw FuelSystemException("Объем заправляемого топлива должен быть больше 0!")
        fuelTank.modifyLevel(amount)
    }

    fun provide(amount: Double)
    {
        if (amount <= 0)
            throw FuelSystemException("Объем потребляемого топлива должен быть больше 0!")
        fuelTank.modifyLevel(-amount)
    }

    override fun toString(): String {
        return "Fuel system $fuelType ${getFuelLevel()}/${getCapacity()} л"
    }

    private class FuelTank(
        val capacity: Double = 60.0
    ) {
        var level: Double = 0.0
            private set

        init {
            require(capacity > 0) { "Ёмкость бака должна быть больше 0" }
        }

        fun modifyLevel(amount: Double)
        {
            if (level + amount > capacity)
                throw FuelSystemException("Объем заправляемого топлива ${amount} превышает свободный объем ${capacity - level}! Уровень: $level из $capacity")
            if (level + amount < 0)
                throw FuelSystemException("Недостаточно топлива ${level + amount}! Текущий уровень: ${level}")
            level += amount
        }
    }
}