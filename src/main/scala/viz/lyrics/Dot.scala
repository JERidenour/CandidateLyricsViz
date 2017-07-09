package viz.lyrics

class Dot {

    private var _preamble = "graph g { " +
        "graph [overlap=false outputorder=edgesfirst];" +
        "node [style=filled fillcolor=white];"
    
    private var _postscipt = "}"
    
    def preamble = _preamble
    def postscript = _postscript
    
    def preamble_= (in:String):Unit = _preamble = in
    def postscript_= (in:String):Unit = _postscript = in

}

object Dot {

    def apply()={


    }
}
