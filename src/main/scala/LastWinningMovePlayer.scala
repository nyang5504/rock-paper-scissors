import benjamingarrett.rockpaperscissorstools.{AWins, Paper, RPSHistoryBasedPlayer, RPSMove, RPSOutcome, Rock, Scissors}

import scala.util.Random

class LastWinningMovePlayer extends RPSHistoryBasedPlayer{
  override def playMove(history: List[(RPSMove, RPSOutcome)]): RPSMove = {
    val moveList = Array(Rock,Paper,Scissors)
    if(history.length == 0) {
      val randomIndex = Random.nextInt(moveList.length)
      moveList(randomIndex)
    }
    else{
      for((move,outcome) <- history){
        if(outcome == AWins) {
          return move
        }
      }
      history(0)._1
    }
  }
}