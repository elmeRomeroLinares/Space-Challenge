import java.text.MessageFormat

const val cargoPhase1File = "phase1.txt"
const val cargoPhase2File = "phase2.txt"

fun main() {
    runMarsSimulation()
}

fun runMarsSimulation() {
    val marsSimulation = Simulation()

    val phase1RocketsU1 = marsSimulation.loadU1(cargoPhase1File)
    val phase1RocketsU2 = marsSimulation.loadU2(cargoPhase1File)
    val phase2RocketsU1 = marsSimulation.loadU1(cargoPhase2File)
    val phase2RocketsU2 = marsSimulation.loadU2(cargoPhase2File)

    val totalCostU1Rockets =
        marsSimulation.runSimulation(phase1RocketsU1) + marsSimulation.runSimulation(phase2RocketsU1)

    val totalCostU2Rockets =
        marsSimulation.runSimulation(phase1RocketsU2) + marsSimulation.runSimulation(phase2RocketsU2)

    println(MessageFormat.format(u1TotalCost, totalCostU1Rockets.toString()))
    println(MessageFormat.format(u2TotalCost, totalCostU2Rockets.toString()))
    println(MessageFormat.format(rocketTypeLowerCost, if(totalCostU1Rockets<totalCostU2Rockets){"U1"} else {"U2"}))
}