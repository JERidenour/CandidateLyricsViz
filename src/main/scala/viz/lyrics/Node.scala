package viz.lyrics

class Node {

    // fields
    private var _rightName = ""
    private var _leftName = ""

    // getters & setters
    def rightName = _rightName
    def leftName = _leftName

    def rightName_= (in:String):Unit = _rightName = in
    def leftName_= (in:String):Unit = _leftName = in
}

object Node {

    // basic constuctor
    def apply(rn: String, ln: String) {

        var n = new Node
        n.rightName = rn
        n.leftName = ln
        n

    }
}
