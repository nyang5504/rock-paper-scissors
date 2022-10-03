package SingleMatch
import benjamingarrett.rockpaperscissorstools.{AWins, BWins, RPSHistoryBasedPlayer, RPSMatch, RPSMove, RPSOutcome, Tie}
import SingleMatchDecider.SingleMatchDecider

object SingleMatch extends RPSMatch {
  override def playMatch(rounds: Int)(firstPlayer: RPSHistoryBasedPlayer)(secondPlayer: RPSHistoryBasedPlayer): List[RPSOutcome] = {
    def doSomething(rounds: Int)(history1: List[(RPSMove, RPSOutcome)])(history2: List[(RPSMove, RPSOutcome)])(outcomeList: List[RPSOutcome]): List[RPSOutcome] = {
      if (rounds == 0) return List.empty
      val histories = addToHistory(history1)(history2)(firstPlayer)(secondPlayer)
      val lastOutcome = List(histories._1.last._2)
      doSomething(rounds - 1)(histories._1)(histories._2)(outcomeList ++ lastOutcome)
    }

    doSomething(rounds)(List.empty)(List.empty)(List.empty)
  }


  private def addToHistory(history1: List[(RPSMove, RPSOutcome)])(history2: List[(RPSMove, RPSOutcome)])
                          (player1: RPSHistoryBasedPlayer)(player2: RPSHistoryBasedPlayer): (List[(RPSMove, RPSOutcome)], List[(RPSMove, RPSOutcome)]) = {
    val player1NextMove = player1.playMove(history1)
    val player2NextMove = player2.playMove(history2)
    val gameResult = SingleMatchDecider.beats(player1NextMove)(player2NextMove)

    if (gameResult == AWins) {
      val player1LatestHistory = List((player1NextMove, AWins))
      val player2LatestHistory = List((player2NextMove, BWins))
      (history1 ++ player1LatestHistory, history2 ++ player2LatestHistory)
    }
    else if (gameResult == BWins) {
      val player1LatestHistory = List((player1NextMove, BWins))
      val player2LatestHistory = List((player2NextMove, AWins))
      (history1 ++ player1LatestHistory, history2 ++ player2LatestHistory)
    }
    else {
      val player1LatestHistory = List((player1NextMove, Tie))
      val player2LatestHistory = List((player2NextMove, Tie))
      (history1 ++ player1LatestHistory, history2 ++ player2LatestHistory)
    }

  }
}


//  override def playMatch(rounds: Int)(firstPlayer: RPSHistoryBasedPlayer)(secondPlayer: RPSHistoryBasedPlayer): List[RPSOutcome] = {
//    var firstPlayerHistory = List.empty
//    var secondPlayerHistory = List.empty
//
//    var resultList = List.empty
//
//    for(_ <- 1 to rounds){
//      val firstPlayerMove = firstPlayer.playMove(firstPlayerHistory)
//      val secondPlayerMove = secondPlayer.playMove(secondPlayerHistory)
//      val roundResult = SingleMatchDecider.beats(firstPlayerMove)(secondPlayerMove)
//      resultList:+roundResult
//      if(roundResult == AWins){
//        firstPlayerHistory:+ (firstPlayerMove, AWins)
//        secondPlayerHistory:+ (secondPlayerMove, BWins)
//      }
//      else if(roundResult == BWins){
//        firstPlayerHistory:+ (firstPlayerMove, BWins)
//        secondPlayerHistory:+ (secondPlayerMove, AWins)
//      }
//      else {
//        firstPlayerHistory:+ (firstPlayerMove, Tie)
//        secondPlayerHistory:+ (secondPlayerMove, Tie)
//      }
//    }
//    resultList
//  }
//}
