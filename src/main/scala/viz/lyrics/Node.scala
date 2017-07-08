package viz.lyrics

class Node {

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

object Node {

    // basic constuctor
    def apply(ln: String, rn: String) = {

        var n = new Node
        n.leftName = ln
        n.rightName = rn
        n

    }
}
