import benjamingarrett.rockpaperscissorstools.{Paper, RPSHistoryBasedPlayer, RPSMove, RPSOutcome, Rock, Scissors}

import scala.util.Random

class RandomMovePlayer extends RPSHistoryBasedPlayer{
  override def playMove(history: List[(RPSMove, RPSOutcome)]): RPSMove = {
    val moveList = Array(Rock,Paper,Scissors)
    val randomIndex = Random.nextInt(moveList.length)
    moveList(randomIndex)
  }
}
