package IndividualMatchRoundRobinTournament
import SingleMatch.SingleMatch
import benjamingarrett.rockpaperscissorstools.{RPSHistoryBasedPlayer, RPSOutcome, RPSTournament}

class IndividualMatchRoundRobinTournament(val roundsPerMatch: Int) extends RPSTournament{
  override def playTournament(entrants: List[RPSHistoryBasedPlayer]): Map[(RPSHistoryBasedPlayer, RPSHistoryBasedPlayer), List[RPSOutcome]] = {
    var resultMap = Map.empty[(RPSHistoryBasedPlayer, RPSHistoryBasedPlayer),List[RPSOutcome]]
    for(player1 <- 0 to entrants.length-1){
      for(player2 <- player1+1 to entrants.length-1){
        val SingleMatchResult = SingleMatch.playMatch(roundsPerMatch)(entrants(player1))(entrants(player2))
        resultMap += (player1,player2) -> SingleMatchResult
      }
    }
    resultMap
  }
}
