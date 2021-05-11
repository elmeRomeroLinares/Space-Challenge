import model.Item

class Rocket(
    val cost: Int, val rocketWeight: Int,
    val maxWeight:Int, var currentWeight: Int
): SpaceShip {
    override fun launch(): Boolean {
        return true
    }

    override fun land(): Boolean {
        return true
    }

    override fun canCarry(item: Item): Boolean {
        val possibleWeight = currentWeight + item.weight
        return possibleWeight < maxWeight
    }

    override fun carry(item: Item) {
        currentWeight += item.weight
    }

}