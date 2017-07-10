package viz.lyrics

class Vertex {

    private var _leftName = ""
    private var _rightName = ""
    private var _color = "#FFFFFF"

    def leftName = _leftName
    def rightName = _rightName
    def color = _color

    def leftName_= (in:String):Unit = _leftName = in
    def rightName_= (in:String):Unit = _rightName = in
    def color_= (in:String):Unit = _color = in

    override def toString: String = {
        s"""$leftName -- $rightName [color="$color"];"""
    }

    def canEqual(a: Any) = a.isInstanceOf[Vertex]

    override def equals(that: Any): Boolean = that match {
        case that: Vertex => that.canEqual(this) && this.hashCode == that.hashCode
        case _ => false
    }

    // set the hash code to the sum, since they are non-directional
    override def hashCode: Int = {
        if ( (this.leftName==null) || (this.rightName==null) || (this.color==null) ) {
            0
        } else {
            this.leftName.hashCode + this.rightName.hashCode + this.color.hashCode
        }
    }
}

object Vertex {

    // weed out characters not accpeted by graphviz
    def createName(label: String) = {
        label
            .replace(" ", "_")
            .replace(".", "")
            .replace("""(""", "")
            .replace(""")""", "")
            .replace("&", "and")
            .replace("-", "")
            .replace(""""""", "")
            .replace("""'""", "")
            .replace("""[""", "")
            .replace("""]""", "")
            .replace("$", "S")
            .replace("2", "two")
            .replace("50", "fifty")
            .replace("7", "seven")
            .replace("69", "sixtynine")
            .replace("1", "one")

    }

    def apply(ln: String, rn: String, c: String) = {

        var v = new Vertex 
        v.leftName = createName(ln)
        v.rightName = createName(rn)
        v.color = c
        v
    }
}
