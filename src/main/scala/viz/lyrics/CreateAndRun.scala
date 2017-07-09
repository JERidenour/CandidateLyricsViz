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
        val candidateColors = Array("#b06660", "#d9a88f", "#ca8f42", 
            "#ab9c73", "#537703", "#9baf8e"), "#6a7d8e", "#dbad72")

        val dot = new Dot()

        // create a node for each artist
        artists.foreach { dot.nodeBuffer += Node.apply(_)  }
        
        // for each candidate get it's subset
        // get the artists for that subset
        // for each artist get the companion artist set
        // create vertex for each such pair
        // print the dot file
    }
}
