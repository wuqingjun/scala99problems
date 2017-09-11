class TrieNode[+T](var isLeaf: Boolean, val children: collection.mutable.HashMap[T, TrieNode[T]]){
  def insert[T](x: Seq[T]): Unit = {
    x.headOption match {
      case Some(head) => {
        children get head match{
          case Some(t) => t.insert(x.tail)
          case _ => {
            children += (head -> new TrieNode[T](false, new collection.mutable.HashMap[T, TrieNode[T]]))
            children(head).insert(x.tail)
          }
        }
      }
      case _ => isLeaf = true
    }
  }
}

val root = new TrieNode(false, new collection.mutable.HashMap[Symbol, TrieNode[Symbol]]())
root.insert(List('a, 'b))
root.children('a).isLeaf
root.children('a).children('b).isLeaf