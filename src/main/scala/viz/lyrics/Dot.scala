package viz.lyrics

class Dot {

    private var _preamble = "graph g { " +
        "graph [overlap=false outputorder=edgesfirst];" +
        "node [style=filled fillcolor=white];"
    
    def preamble = _preamble
    
    def preamble_= (in:String):Unit = _preamble = in

}

object Dot {

    def apply()={


    }
}
