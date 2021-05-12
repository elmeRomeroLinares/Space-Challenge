import java.io.File
import java.io.FileNotFoundException
import java.util.*

class FileReader {
    var itemScanner: Scanner? = null

    fun fileReaderScanner(fileName: String) : Scanner? {
        val getPhaseItems = File(fileName)
        try {
            itemScanner = Scanner(getPhaseItems)
        } catch (e: FileNotFoundException) {
            println("Error reading text file")
        }
        return itemScanner
    }
}