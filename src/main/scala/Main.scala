import PrimitiveDecider.PrimitiveDecider
import scala.io.StdIn.readLine
object Main extends App {
  var cont = true
  while (cont) {
    println("Enter first move:")
    val a = readLine()
    println("Enter second move:")
    val b = readLine()
    println(PrimitiveDecider.beats(a,b))
    println("Play another round? (true/false)")
    val c = readLine()
    if (c == "false"){
      cont = false
    }
  }
}
