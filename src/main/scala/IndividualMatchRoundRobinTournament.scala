import benjamingarrett.rockpaperscissorstools.{AWins, BWins, RPSHistoryBasedPlayer, RPSMatch, RPSOutcome}
import SingleMatchDecider.SingleMatchDecider

class IndividualMatchRoundRobinTournament extends RPSMatch{
  override def playMatch(rounds: Int)(firstPlayer: RPSHistoryBasedPlayer)(secondPlayer: RPSHistoryBasedPlayer): List[RPSOutcome] = {
    var firstPlayerPoints = 0
    var secondPlayerPoints = 0
    for(_ <- 1 to rounds) {
      var firstPlayerMove = {
      if(SingleMatchDecider.beats(firstPlayer.playMove(List.empty))(secondPlayer.playMove(List.empty)) == AWins) {
        firstPlayerPoints+=1
      }
      else {
        secondPlayerPoints+=1
      }


      }
    }
  }

}
