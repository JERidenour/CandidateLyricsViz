package viz.lyrics

import com.github.tototoshi.csv._
import java.io.File

object CreateAndRun {
    def main(args: Array[String]) {

        val reader = CSVReader.open(new File("src/main/resources/genius_hip_hop_lyrics.csv"))
        val data = reader.all()
        reader.close()        

    }
}
