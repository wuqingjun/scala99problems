class TrieNode(var isLeaf: Boolean, val children: collection.mutable.HashMap[Symbol, TrieNode]) {
  def addValue(s: List[Symbol]): Unit = s match {
    case Nil => { println("Nil"); isLeaf = true;}
    case head :: tail => {
      if(!children.contains(head)) children.put(head, new TrieNode(false, collection.mutable.HashMap()))
      children(head).addValue(tail)
    }
  }
}


/*
case object End extends Trie[Nothing] {
  override def addValue[U >: Nothing <% Ordered[U]](x: U): Trie[U] =
}
*/

val root = new TrieNode(false, collection.mutable.HashMap())
root.addValue(List('a, 'b))

println(root.isLeaf)
println(root.children)
println(root.children('a).children('b).isLeaf)

