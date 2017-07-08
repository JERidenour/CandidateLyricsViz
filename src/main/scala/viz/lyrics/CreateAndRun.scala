package viz.lyrics

import com.github.tototoshi.csv._
import java.io.File

object CreateAndRun {
    def main(args: Array[String]) {

        // load the data
        val reader = CSVReader
            .open(new File("src/main/resources/genius_hip_hop_lyrics.csv"))
        val data = reader.all()
        reader.close()        

        // pick out unique lists
        val artists = data.map(x => x.apply(3)).distinct.tail
        val candidates = data.map(x => x.apply(1)).distinct.tail

        // create a node for each artist
        // create verticies
        // print the dot file
    }
}
