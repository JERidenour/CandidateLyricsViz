package viz.lyrics

import com.github.tototoshi.csv._
import java.io.File
import java.nio.file.{Paths, Files}
import java.nio.charset.StandardCharsets
import sys.process._

object CandidateHub {
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
            "#388659", "#404f24", "#4c86a8", "#360568", "#9e2a2b")

        val dot = new Dot()

        // create a node for each artist and candidate
        artists.foreach { dot.nodeBuffer += Node.apply(_)  }
        candidates.foreach { dot.nodeBuffer += Node.apply(_)  }
        
        for( c <- 0 to (candidates.length-1) ){

            // for each candidate get it's subset
            val subset = data.filter( (r:List[String]) => r.apply(1) == candidates(c) ) 
        
            // get the artists for that subset
            val subArtists = subset.map(x => x.apply(3)).distinct

            for( sa <- subArtists){

                // create edge from each artist to the candidate 
                dot.edgeBuffer += Edge.apply(sa, candidates(c), candidateColors.apply(c))
            }
        }

    // write to file
    Files.write(Paths.get("src/main/resources/CandidateHub.dot"), 
        dot.toString.getBytes(StandardCharsets.UTF_8))

    // system call to graphviz
    "neato src/main/resources/CandidateHub.dot -Tsvg -osrc/main/resources/CandidateHub.svg" ! 
    }
}
