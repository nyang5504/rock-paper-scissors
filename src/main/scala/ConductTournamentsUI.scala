import IndividualMatchRoundRobinTournament.IndividualMatchRoundRobinTournament
import SingleMatch.SingleMatch
import benjamingarrett.rockpaperscissorstools.RPSHistoryBasedPlayer

import scala.io.StdIn.readLine

object ConductTournamentsUI extends App {

  var listPlayers = List[RPSHistoryBasedPlayer]()

  println("How many LastLosingMovePlayer? Enter an integer")
  val LLMP = readLine().toInt
  for(x <- 1 to LLMP){
    listPlayers = listPlayers ++ List(new LastLosingMovePlayer())
  }

  println("How many LastWinningMovePlayer? Enter an integer")
  val LWMP = readLine().toInt
  for(x <- 1 to LWMP){
    listPlayers = listPlayers ++ Array(new LastWinningMovePlayer())
  }

  println("How many MajorityLosingPlayer? Enter an integer")
  val MLP = readLine().toInt
  for(x <- 1 to MLP){
    listPlayers = listPlayers++Array(new MajorityLosingMovePlayer())
  }

  println("How many MajorityWinningPlayer? Enter an integer")
  val MWP = readLine().toInt
  for(x <- 1 to MWP){
    listPlayers = listPlayers++Array(new MajorityWinningMovePlayer())
  }

  println("How many RandomMovePlayer? Enter an integer")
  val RMP = readLine().toInt
  for(x <- 1 to RMP){
    listPlayers = listPlayers++Array(new RandomMovePlayer())
  }

  println("How many BiasedRandomMovePlayer? Enter an integer")
  val BRMP = readLine().toInt
  println("Percent chance of Rock")
  val rockChance = readLine().toInt
  println("Percent chance of Paper")
  val paperChance = readLine().toInt
  println("Percent chance of Scissors")
  val scissorsChance = readLine().toInt
  for(x <- 1 to BRMP){
    listPlayers = listPlayers++Array(new BiasedRandomMovePlayer(Array(rockChance,paperChance,scissorsChance)))
  }

  println("How many tournaments?")
  val numTourney = readLine().toInt
  println("How many rounds per match?")
  val numRounds = readLine().toInt

  var tourneyList = List[IndividualMatchRoundRobinTournament]()
  for(_ <- 1 to numTourney){
    tourneyList = tourneyList ++ List(new IndividualMatchRoundRobinTournament(numRounds))
  }

  val mixedTournament1 = new MixedTournamentSeason(numRounds)
  val mixedTourneyResults = mixedTournament1.handleTournamentSeason(listPlayers)(tourneyList)
  for ((player, points) <- mixedTourneyResults){
    println(player + " -> " + points + "Points")
  }
}
