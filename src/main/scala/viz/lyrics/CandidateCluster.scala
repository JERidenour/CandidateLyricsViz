package viz.lyrics

import com.github.tototoshi.csv._
import java.io.File
import java.nio.file.{Paths, Files}
import java.nio.charset.StandardCharsets
import sys.process._

object CandidateCluster {
    def main(args: Array[String]) {

        // load the data
        val reader = CSVReader
            .open(new File("src/main/resources/genius_hip_hop_lyrics.csv"))
        val data = reader.all()
        reader.close()        

        // pick out unique lists
        val artists = data.map(x => x.apply(3)).distinct.tail
        val candidates = data.map(x => x.apply(1)).distinct.tail
        val candidateColors = Array("#493829", "#3e000c", "#564787", 
            "#8ed081", "#404f24", "#4c86a8", "#360568", "#9e2a2b")

        // set the drawing parameters for the dot object
        var graph = "[overlap=false " + 
            "outputorder=edgesfirst " +
            "size=24];"
        var edge = "[weight=2, penwidth=5];"
        var node = "[fontsize=32 width=5 " + 
            "shape=ellipse style=filled fillcolor=white];"

        val dot = Dot.apply(graph, edge, node)

        // create a node for each artist
        artists.foreach { dot.nodeBuffer += Node.apply(_)  }
        
        for( c <- 0 to (candidates.length-1) ){

            // for each candidate get it's subset
            val subset = data.filter( (r:List[String]) => r.apply(1) == candidates(c) ) 
        
            // get the artists for that subset
            val subArtists = subset.map(x => x.apply(3)).distinct

            for( sa <- subArtists){
            
                // for each artist get the companion artist set
                val compArtists = subArtists.filter( (a:String) => a != sa  ) 

                for(sac <- compArtists){

                    // create edge for each such pair
                    dot.edgeBuffer += Edge.apply(sa, sac, 
                        candidateColors.apply(c))
                }
            }
        }

    // write to file
    Files.write(Paths.get("src/main/resources/CandidateCluster.dot"), 
        dot.toString.getBytes(StandardCharsets.UTF_8))

    // system call to graphviz
    "neato src/main/resources/CandidateCluster.dot -Tsvg -osrc/main/resources/CandidateCluster.svg " !
    }
}
