import java.text.MessageFormat

const val CARGO_PHASE1_FILE = "phase1.txt"
const val CARGO_PHASE2_FILE = "phase2.txt"

fun main() {
    runMarsSimulation()
}

fun runMarsSimulation() {
    val marsSimulation = Simulation()

    val phase1RocketsU1 = marsSimulation.loadU1(CARGO_PHASE1_FILE)
    val phase1RocketsU2 = marsSimulation.loadU2(CARGO_PHASE1_FILE)
    val phase2RocketsU1 = marsSimulation.loadU1(CARGO_PHASE2_FILE)
    val phase2RocketsU2 = marsSimulation.loadU2(CARGO_PHASE2_FILE)

    val totalCostU1Rockets =
        marsSimulation.runSimulation(phase1RocketsU1) + marsSimulation.runSimulation(phase2RocketsU1)

    val totalCostU2Rockets =
        marsSimulation.runSimulation(phase1RocketsU2) + marsSimulation.runSimulation(phase2RocketsU2)

    println(MessageFormat.format(U1_TOTAL_COST, totalCostU1Rockets.toString()))
    println(MessageFormat.format(U2_TOTAL_COST, totalCostU2Rockets.toString()))
    println(MessageFormat.format(ROCKET_TYPE_LOWER_COST, if(totalCostU1Rockets<totalCostU2Rockets){"U1"} else {"U2"}))
}