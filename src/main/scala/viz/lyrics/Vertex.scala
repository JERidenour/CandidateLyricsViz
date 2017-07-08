package viz.lyrics

class Vertex {

    // fields
    private var _leftName = ""
    private var _rightName = ""

    // getters & setters
    def leftName = _leftName
    def rightName = _rightName

    def leftName_= (in:String):Unit = _leftName = in
    def rightName_= (in:String):Unit = _rightName = in

    override def toString: String = {
        s"$leftName -- $rightName"
    }
}

object Vertex {

    // basic constuctor
    def apply(ln: String, rn: String) = {

        var v = new Vertex 
        v.leftName = ln
        v.rightName = rn
        v

    }
}
