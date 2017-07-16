package viz.lyrics

import scala.collection.mutable.ArrayBuffer

class Dot {

    private var _graphParam = "[overlap=false outputorder=edgesfirst size=24 bgcolor=gray];"
    private var _edgeParam = "[weight=2, penwidth=5];"
    private var _nodeParam = "[fontsize=32 width=5 shape=ellipse style=filled fillcolor=white];"

    private var _preamble = "graph g { " +
        //"graph [overlap=false outputorder=edgesfirst size=24];" + //CandidateCluster
        //"node [style=filled fillcolor=white];" //CandidateCluster
        "graph" + _graphParam +
        "edge" + _edgeParam +
        "node" + _nodeParam 
    
    private var _postscript = "}"

    var nodeBuffer = new ArrayBuffer[Node]
    var edgeBuffer = new ArrayBuffer[Edge]
    
    def preamble = _preamble
    def postscript = _postscript
    
    def preamble_= (in:String):Unit = _preamble = in
    def postscript_= (in:String):Unit = _postscript = in

    override def toString: String = {

        var s = this.preamble
        s += this.nodeBuffer.mkString
        s += this.edgeBuffer.distinct.mkString
        s += this.postscript
        s
    }
}
