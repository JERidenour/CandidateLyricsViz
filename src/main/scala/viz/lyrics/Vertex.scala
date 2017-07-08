package viz.lyrics

class Vertex {

    /* fields
    / names should be clean of any characters not allowed by graphviz
    / colors should be hex-formated
    */ 
    private var _leftName = ""
    private var _rightName = ""
    private var _color = "#FFFFFF"

    // getters & setters
    def leftName = _leftName
    def rightName = _rightName
    def color = _color

    def leftName_= (in:String):Unit = _leftName = in
    def rightName_= (in:String):Unit = _rightName = in
    def color_= (in:String):Unit = _color = in

    override def toString: String = {
        s"""$leftName -- $rightName [color="$color"]"""
    }
}

object Vertex {

    // basic constuctor
    def apply(ln: String, rn: String, c: String) = {

        var v = new Vertex 
        v.leftName = ln
        v.rightName = rn
        v.color = c
        v
    }
}
