import kotlin.random.Random

class RocketU2: Rocket(u2Price, u2Weight, u2MaxCargoWeight, u2InitialWeight) {

    companion object {
        const val u2Price = 120 //millions
        const val u2Weight = 18000 //weight in kg
        const val u2MaxCargoWeight = 29000 - u2Weight //max weight in kg
        const val u2InitialWeight = 0
    }

    override fun launch(): Boolean {
        val u2LaunchExplosionChance = 0.04 * currentWeight/(u2MaxCargoWeight)
        return u2LaunchExplosionChance < Random.nextDouble()
    }

    override fun land(): Boolean {
        val u2LandExplosionChance = 0.08 * currentWeight/(u2MaxCargoWeight)
        return u2LandExplosionChance < Random.nextDouble()
    }
}