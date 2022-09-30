import benjamingarrett.rockpaperscissorstools.{BWins, Paper, RPSHistoryBasedPlayer, RPSMove, RPSOutcome, Rock, Scissors}

import scala.util.Random

class MajorityLosingMovePlayer extends RPSHistoryBasedPlayer{
  var rockLoses = 0
  var paperLoses = 0
  var scissorsLoses = 0
  override def playMove(history: List[(RPSMove, RPSOutcome)]): RPSMove = {
    for((move, outcome) <- history) {
      if(outcome == BWins) {
        if(move == Rock) rockLoses+=1
        else if(move == Paper) paperLoses+=1
        else scissorsLoses+=1
      }
    }

    var nextMove: RPSMove = Rock
    var largestSoFar = rockLoses
    if(paperLoses == rockLoses && scissorsLoses == rockLoses){
      val rand = Random.nextInt(3)
      if(rand == 0) return Rock
      if(rand == 1) return Paper
      return Scissors
    }

    if(rockLoses == paperLoses){
      val rand = Random.nextInt(2)
      if(rand == 0) {
        nextMove = Rock
        largestSoFar = rockLoses
      }
      else {
        nextMove = Paper
        largestSoFar = paperLoses
      }
    }

    if(rockLoses == scissorsLoses){
      val rand = Random.nextInt(2)
      if(rand == 0) {
        nextMove = Rock
        largestSoFar = rockLoses
      }
      else {
        nextMove = Scissors
        largestSoFar = scissorsLoses
      }
    }

    if(paperLoses == scissorsLoses){
      val rand = Random.nextInt(2)
      if(rand == 0) {
        nextMove = Paper
        largestSoFar = paperLoses
      }
      else {
        nextMove = Scissors
        largestSoFar = scissorsLoses
      }
    }

    if(paperLoses > largestSoFar) {
      nextMove = Paper
      largestSoFar = paperLoses
    }
    if(scissorsLoses > largestSoFar) {
      nextMove = Scissors
      largestSoFar = scissorsLoses
    }

    nextMove

  }
}
