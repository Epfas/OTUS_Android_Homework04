package ru.otus.cars

/**
 * Автозавод
 */
interface CarFactory {
    /**
     * Выпусти машину
     */
    fun buildCar(builder: CarBuilder, plates: Car.Plates, fuelType: FuelType = FuelType.PETROL, tankCapacity:Double = 60.0): Car
}

/**
 * Автозавод в Тольятти (он у нас один такой)
 */
object Togliatti : CarFactory {
    private fun buildVaz2107(plates: Car.Plates, fuelType: FuelType, tankCapacity:Double): Car {
        println("")
        println("Запил ${Vaz2107.MODEL} в Тольятти...")
        val vaz = Vaz2107.build(plates)
        try {
            println("Устанавливаем топливную систему на ${fuelType} с объемом $tankCapacity л ...")
            vaz.fuelSystem = FuelSystem(fuelType, tankCapacity)
            println("Комплектация: " + vaz.getEquipment())
            println("Заправляем PETROL 10л ...")
            vaz.tankMouth.refuel(FuelType.PETROL, 10.0)
            println("Текущий уровень топлива ${vaz.fuelSystem.getFuelLevel()}л")
            println("Проверяем тачку...")
            Vaz2107.test(vaz)
            vaz.drdrdrdrdr()
        }
        catch (ex: Exception)
        {
            println("Ошибка: ${ex.message}")
        }
        finally {
            println("")
        }
        return vaz
    }

    private fun buildVaz2108(plates: Car.Plates, fuelType: FuelType, tankCapacity:Double): Car
    {
        println("")
        println("Запил ${Vaz2108.MODEL} в Тольятти...")
        val vaz = Vaz2108.build(plates)
        try {
            println("Устанавливаем топливную систему на ${fuelType} с объемом $tankCapacity л ...")
            vaz.fuelSystem = FuelSystem(fuelType, tankCapacity)
            println("Комплектация: " + vaz.getEquipment())
            println("Сход-развал...")
            Vaz2108.alignWheels(vaz)
            println("Заправляем PETROL 10л ...")
            vaz.tankMouth.refuel(FuelType.PETROL, 10.0)
            println("Текущий уровень топлива ${vaz.fuelSystem.getFuelLevel()}")
            vaz.zhzhzhzh()
        }
        catch (ex: Exception)
        {
            println("Ошибка: ${ex.message}")
        }
        finally {
            println("")
        }
        return vaz
    }

    override fun buildCar(builder: CarBuilder, plates: Car.Plates, fuelType: FuelType, tankCapacity:Double): Car {
        return when (builder) {
            is Vaz2107.Companion -> return buildVaz2107(plates, fuelType, tankCapacity)
            is Vaz2108.Companion -> return buildVaz2108(plates, fuelType, tankCapacity)
        }
    }
}