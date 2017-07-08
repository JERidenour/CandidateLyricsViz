package viz.lyrics

class Node {

    // fields
    private var _name = ""
    private var _label = ""

    // getters & setters
    def name = _name
    def label = _label

    def name_= (in:String):Unit = _name = in
    def label_= (in:String):Unit = _label = in

    override def toString: String = {
        s"""$name [label = "$label"]"""
    }
}

object Node {

    // basic constuctor
    def apply(lab: String) = {

        var n = new Node 
        n.label = lab 
        n

    }
}
