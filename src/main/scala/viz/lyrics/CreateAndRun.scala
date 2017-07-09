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
            "#ab9c73", "#537703", "#9baf8e", "#6a7d8e", "#dbad72")

        val dot = new Dot()

        // create a node for each artist
        artists.foreach { dot.nodeBuffer += Node.apply(_)  }
        
        for( c <- 0 to (candidates.length-1) ){

            // for each candidate get it's subset
            val subset = data.filter( (r:List[String]) => r.apply(1) == c  ) 
        
            // get the artists for that subset
            val subArtists = subset.map(x => x.apply(3)).distinct.tail

            for( sa <- subArtists){
            
                // for each artist get the companion artist set
                val compArtists = subArtists.filter( (a:String) => a != sa  ) 

                for(sac <- compArtists){

                    // create vertex for each such pair
                    dot.vertexBuffer += Vertex.apply(sa, sac, candidateColors.apply(c))
                }
            }
        }
        
        println(dot.toString)


    }
}
