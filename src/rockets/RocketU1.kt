package rockets

import kotlin.random.Random

class RocketU1: Rocket(u1Price, u1Weight, u1MaxCargoWeight, u1InitialWeight) {

    companion object {
        const val u1Price = 100 //millions
        const val u1Weight = 10000 //weight in kg
        const val u1MaxCargoWeight = 18000 - u1Weight //max weight in kg
        const val u1InitialWeight = 0
    }

    override fun launch(): Boolean {
        val u1LaunchExplosionChance = 0.05 * currentWeight/(u1MaxCargoWeight)
        return u1LaunchExplosionChance < Random.nextDouble(until = 0.1)
    }

    override fun land(): Boolean {
        val u1LandExplosionChance = 0.01 * currentWeight/(u1MaxCargoWeight)
        return u1LandExplosionChance < Random.nextDouble(until = 0.1)
    }
}