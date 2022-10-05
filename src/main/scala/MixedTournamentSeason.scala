import benjamingarrett.rockpaperscissorstools.{AWins, BWins, RPSHistoryBasedPlayer, RPSOutcome, RPSPointsSchema, RPSTournament, RPSTournamentSeason}
import IndividualMatchRoundRobinTournament.IndividualMatchRoundRobinTournament


class MixedTournamentSeason(val roundsPerMatch: Int) extends RPSTournamentSeason{
  override def handleTournamentSeason(players: List[RPSHistoryBasedPlayer])(tournaments: List[RPSTournament]): Map[RPSHistoryBasedPlayer, Int] = {
    var resultMap = Map.empty[RPSHistoryBasedPlayer,Int]
    for (player <- players){
      resultMap += player -> 0
    }

    for(tournament <- tournaments){
      var SingleTourneyMap = Map.empty[RPSHistoryBasedPlayer,Int]
      for (player <- players){
        SingleTourneyMap += player -> 0
      }


      val SingleTournamentResult = tournament.playTournament(players)
      for((playerPair,resultList) <- SingleTournamentResult){
        var player1WinCount = 0
        var player2WinCount = 0

        for (result <- resultList){
          if(result == AWins) player1WinCount+=1
          if(result == BWins) player2WinCount+=1
        }
        if(player1WinCount > player2WinCount) {
          SingleTourneyMap += playerPair._1 -> (SingleTourneyMap(playerPair._1)+1)
        }
        if(player1WinCount < player2WinCount) {
          SingleTourneyMap += playerPair._2 -> (SingleTourneyMap(playerPair._2)+1)
        }
      }
      var arrayTourney = SingleTourneyMap.toArray
      for(i <- 0 to arrayTourney.length-1){
        for(j <- i to arrayTourney.length-1){
          if(arrayTourney(j)._2 > arrayTourney(i)._2){
            val temp = arrayTourney(i)
            arrayTourney(i) = arrayTourney(j)
            arrayTourney(j) = temp
          }
        }
      }

      var tourneyRanks = Map.empty[RPSHistoryBasedPlayer,Int]
      for(i <- 0 to arrayTourney.length-1){
        tourneyRanks += arrayTourney(i)._1 -> (i+1)
      }
      tourneyRanks.map {case (player, points) => player -> RPSPointsSchema.pointsAwarded(points)}

      for((key, value) <- tourneyRanks){
        resultMap += key -> (value + resultMap(key))
      }

    }
    resultMap
  }

//  override def handleTournamentSeason(players: List[RPSHistoryBasedPlayer])(tournaments: List[RPSTournament]): Map[RPSHistoryBasedPlayer, Int] = ???
}
