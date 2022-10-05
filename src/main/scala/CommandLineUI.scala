import IndividualMatchRoundRobinTournament.IndividualMatchRoundRobinTournament
import PrimitiveDecider.PrimitiveDecider
import SingleMatch.SingleMatch

import scala.io.StdIn.readLine
object CommandLineUI extends App {
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
