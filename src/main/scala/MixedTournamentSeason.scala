import benjamingarrett.rockpaperscissorstools.{AWins, BWins, RPSHistoryBasedPlayer, RPSOutcome, RPSTournament, RPSTournamentSeason}
import IndividualMatchRoundRobinTournament.IndividualMatchRoundRobinTournament

class MixedTournamentSeason(val roundsPerMatch: Int)(val numTournaments: Int) extends RPSTournamentSeason{
//  override def handleTournamentSeason(players: List[RPSHistoryBasedPlayer])(tournaments: List[RPSTournament]): Map[RPSHistoryBasedPlayer, Int] = {
//    var resultMap = Map.empty[RPSHistoryBasedPlayer,Int]
//    for (player <- players){
//      resultMap += player -> 0
//    }
//
//    for(_ <- 1 to numTournaments){
//      val tournament = new IndividualMatchRoundRobinTournament(roundsPerMatch)
//
//      var player1WinCount = 0
//      var player2WinCount = 0
//      val SingleTournamentResult = tournament.playTournament(players)
//      for((playerPair,resultList) <- SingleTournamentResult){
//        for (result <- resultList){
//          if(result == AWins) player1WinCount+=1
//          if(result == BWins) player2WinCount+=1
//        }
//        if(player1WinCount > player2WinCount) {
//          resultMap(playerPair._1) +=1
//        }
//        if(player1WinCount < player2WinCount) {
//          resultMap(playerPair._2) +=1
//        }
//      }
//    }
//    resultMap
//  }

  override def handleTournamentSeason(players: List[RPSHistoryBasedPlayer])(tournaments: List[RPSTournament]): Map[RPSHistoryBasedPlayer, Int] = ???
}
