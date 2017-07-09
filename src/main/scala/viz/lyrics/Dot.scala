package viz.lyrics

import scala.collection.mutable.ArrayBuffer

class Dot {

    private var _preamble = "graph g { " +
        "graph [overlap=false outputorder=edgesfirst];" +
        "node [style=filled fillcolor=white];"
    
    private var _postscript = "}"

    var nodeBuffer = new ArrayBuffer[Node]
    var vertexBuffer = new ArrayBuffer[Vertex]
    
    def preamble = _preamble
    def postscript = _postscript
    
    def preamble_= (in:String):Unit = _preamble = in
    def postscript_= (in:String):Unit = _postscript = in

}

object Dot {

    def apply()={


    }
}
