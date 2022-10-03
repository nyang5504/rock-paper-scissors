import PrimitiveDecider.PrimitiveDecider
import SingleMatch.SingleMatch

import scala.io.StdIn.readLine
object CommandLineUI extends App {
//  var cont = true
//  while (cont) {
//    println("Enter first move:")
//    val a = readLine()
//    println("Enter second move:")
//    val b = readLine()
//    println(PrimitiveDecider.beats(a,b))
//    println("Play another round? (true/false)")
//    val c = readLine()
//    if (c == "false"){
//      cont = false
//    }
//  }

  val player1 = new MajorityWinningMovePlayer()
  val player2 =  new LastLosingMovePlayer()
  val outcome = SingleMatch.playMatch(3)(player1)(player2)
  println(outcome)
}
