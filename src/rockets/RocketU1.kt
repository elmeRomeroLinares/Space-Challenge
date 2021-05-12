package rockets

import kotlin.random.Random

class RocketU1: Rocket(U1_PRICE, U1_WEIGHT, U1_MAX_CARGO_WEIGHT, U1_INITIAL_CARGO_WEIGHT) {

    companion object {
        const val U1_PRICE = 100 //millions
        const val U1_WEIGHT = 10000 //weight in kg
        const val U1_MAX_CARGO_WEIGHT = 18000 - U1_WEIGHT //max weight in kg
        const val U1_INITIAL_CARGO_WEIGHT = 0
    }

    override fun launch(): Boolean {
        val u1LaunchExplosionChance = 0.05 * currentWeight/(U1_MAX_CARGO_WEIGHT)
        return u1LaunchExplosionChance < Random.nextDouble(until = 0.1)
    }

    override fun land(): Boolean {
        val u1LandExplosionChance = 0.01 * currentWeight/(U1_MAX_CARGO_WEIGHT)
        return u1LandExplosionChance < Random.nextDouble(until = 0.1)
    }
}