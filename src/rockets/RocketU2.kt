package rockets

import kotlin.random.Random

class RocketU2: Rocket(U2_PRICE, U2_WEIGHT, U2_MAX_CARGO_WEIGHT, U2_INITIAL_CARGO_WEIGHT) {

    companion object {
        const val U2_PRICE = 120 //millions
        const val U2_WEIGHT = 18000 //weight in kg
        const val U2_MAX_CARGO_WEIGHT = 29000 - U2_WEIGHT //max weight in kg
        const val U2_INITIAL_CARGO_WEIGHT = 0
    }

    override fun launch(): Boolean {
        val u2LaunchExplosionChance = 0.04 * currentWeight/(U2_MAX_CARGO_WEIGHT)
        return u2LaunchExplosionChance < Random.nextDouble(until = 0.1)
    }

    override fun land(): Boolean {
        val u2LandExplosionChance = 0.08 * currentWeight/(U2_MAX_CARGO_WEIGHT)
        return u2LandExplosionChance < Random.nextDouble(until = 0.1)
    }
}