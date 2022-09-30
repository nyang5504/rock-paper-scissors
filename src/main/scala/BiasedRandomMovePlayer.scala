import benjamingarrett.rockpaperscissorstools.{Paper, RPSHistoryBasedPlayer, RPSMove, RPSOutcome, Rock, Scissors}

import scala.util.Random

class BiasedRandomMovePlayer(val arr: Array[Int]) extends RPSHistoryBasedPlayer {

  override def playMove(history: List[(RPSMove, RPSOutcome)]): RPSMove = {
    val randNumArray = Array(arr(0),arr(0)+arr(1),100)
    val randomNum = Random.nextInt(100)

    if (randomNum < randNumArray(0)) {
      return Rock
    }
    else if(randomNum < randNumArray(1)) {
      return Paper
    }
    else {
      return Scissors
    }
  }
}
