import scala.io.Source
def processFile(filename: String, width: Int): Unit = {
  def processLine(line: String): Unit ={
    if(line.length > width) print(filename + ": " + line)
  }
  val source = Source.fromFile(filename)
  for(line <-source.getLines){
    processLine(line)
  }
}