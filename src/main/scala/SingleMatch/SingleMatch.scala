package SingleMatch
import benjamingarrett.rockpaperscissorstools.{AWins, BWins, RPSHistoryBasedPlayer, RPSMatch, RPSMove, RPSOutcome, Tie}
import SingleMatchDecider.SingleMatchDecider

object SingleMatch extends RPSMatch{
  override def playMatch(rounds: Int)(firstPlayer: RPSHistoryBasedPlayer)(secondPlayer: RPSHistoryBasedPlayer): List[RPSOutcome] = {
    var firstPlayerHistory = List.empty
    var secondPlayerHistory = List.empty

    var resultList = List.empty

    for(_ <- 1 to rounds){
      var firstPlayerMove = firstPlayer.playMove(firstPlayerHistory)
      var secondPlayerMove = secondPlayer.playMove(secondPlayerHistory)
      var roundResult = SingleMatchDecider.beats(firstPlayerMove)(secondPlayerMove)
      resultList:+roundResult
      if(roundResult == AWins){
        firstPlayerHistory:+ (firstPlayerMove, AWins)
        secondPlayerHistory:+ (secondPlayerMove, BWins)
      }
      else if(roundResult == BWins){
        firstPlayerHistory:+ (firstPlayerMove, BWins)
        secondPlayerHistory:+ (secondPlayerMove, AWins)
      }
      else {
        firstPlayerHistory:+ (firstPlayerMove, Tie)
        secondPlayerHistory:+ (secondPlayerMove, Tie)
      }
    }
    resultList
  }
}
