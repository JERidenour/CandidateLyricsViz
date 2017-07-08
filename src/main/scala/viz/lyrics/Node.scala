package viz.lyrics

class Node {

    // fields
    private var _name = ""

    // getters & setters
    def name = _name

    def name_= (in:String):Unit = _name = in

    override def toString: String = {
        s"$name"
    }
}

object Node {

    // basic constuctor
    def apply(nm: String) = {

        var n = new Node 
        n.name = nm
        n

    }
}
