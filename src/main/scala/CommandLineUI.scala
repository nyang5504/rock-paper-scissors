import IndividualMatchRoundRobinTournament.IndividualMatchRoundRobinTournament
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
  val player3 = new RandomMovePlayer()
  val player4 = new MajorityLosingMovePlayer()
  val outcome = SingleMatch.playMatch(3)(player1)(player2)
  println(outcome)

  val entrants = List(player1,player2,player3,player4)
  val tournament1 = new IndividualMatchRoundRobinTournament(5)
  val tournamentOutcome = tournament1.playTournament(entrants)
  println(tournamentOutcome)

  val tournament2 = new IndividualMatchRoundRobinTournament(5)
  val tournamentSeason1 = new MixedTournamentSeason(5)
  val result = tournamentSeason1.handleTournamentSeason(entrants)(List(tournament1,tournament2))
  println(result)
}
