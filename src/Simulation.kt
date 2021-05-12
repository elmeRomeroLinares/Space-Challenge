class Simulation {

    private fun loadItem(path: String) : ArrayList<Item> {
        val scanner = FileReader().fileReaderScanner(path)
        val itemCargoList = ArrayList<Item>()
        scanner?.let{
            while (it.hasNextLine()) {
                val itemInFile = it.nextLine().split("=")
                itemCargoList.add (
                    Item(
                        name = itemInFile[0],
                        weight = Integer.parseInt(itemInFile[1])
                    )
                )
            }
        }
        return itemCargoList
    }

    fun loadU1(filePath: String) : ArrayList<Rocket> {
        val rocketU1List = ArrayList<Rocket>()
        val itemsCargoList = loadItem(filePath)
        var rocket = RocketU1()
        if (itemsCargoList.isNotEmpty()){
            for (item in itemsCargoList) {
                if (rocket.canCarry(item)){
                    rocket.carry(item)
                } else {
                    rocketU1List.add(rocket)
                    rocket = RocketU1()
                    rocket.carry(item)
                }
            }

            rocketU1List.add(rocket)
        }

        return rocketU1List
    }

    fun loadU2(filePath: String): ArrayList<Rocket> {
        val rocketU2List = ArrayList<Rocket>()
        val itemsCargoList = loadItem(filePath)
        var rocket = RocketU2()
        if (itemsCargoList.isNotEmpty()){
            for (item in itemsCargoList) {
                if (rocket.canCarry(item)){
                    rocket.carry(item)
                } else {
                    rocketU2List.add(rocket)
                    rocket = RocketU2()
                    rocket.carry(item)
                }
            }

            rocketU2List.add(rocket)
        }

        return rocketU2List
    }

    fun runSimulation(rocketList: ArrayList<Rocket>) : Long {
        var totalCost: Long = 0

        for (rocket in rocketList) {
            var rocketLaunch = rocket.launch()
            var rocketLand = rocket.land()
            if (rocketLaunch && rocketLand) {
                totalCost += rocket.cost
            } else {
                while (!rocketLaunch || !rocketLand) {
                    rocketLaunch = rocket.launch()
                    rocketLand =  rocket.land()
                    totalCost += rocket.cost
                }
            }
        }

        return totalCost
    }
}