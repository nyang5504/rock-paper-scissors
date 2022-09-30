import benjamingarrett.rockpaperscissorstools.{AWins, Paper, RPSHistoryBasedPlayer, RPSMove, RPSOutcome, Rock, Scissors}

import scala.util.Random

class MajorityWinningMovePlayer extends RPSHistoryBasedPlayer{
  var rockWins = 0
  var paperWins = 0
  var scissorsWins = 0
  override def playMove(history: List[(RPSMove, RPSOutcome)]): RPSMove = {
    for((move, outcome) <- history) {
      if(outcome == AWins) {
        if(move == Rock) rockWins+=1
        else if(move == Paper) paperWins+=1
        else scissorsWins+=1
      }
    }

    var nextMove: RPSMove = Rock
    var largestSoFar = rockWins
    if(paperWins == rockWins && scissorsWins == rockWins){
      val rand = Random.nextInt(3)
      if(rand == 0) return Rock
      if(rand == 1) return Paper
      return Scissors
    }

    if(rockWins == paperWins){
      val rand = Random.nextInt(2)
      if(rand == 0) {
        nextMove = Rock
        largestSoFar = rockWins
      }
      else {
        nextMove = Paper
        largestSoFar = paperWins
      }
    }

    if(rockWins == scissorsWins){
      val rand = Random.nextInt(2)
      if(rand == 0) {
        nextMove = Rock
        largestSoFar = rockWins
      }
      else {
        nextMove = Scissors
        largestSoFar = scissorsWins
      }
    }

    if(paperWins == scissorsWins){
      val rand = Random.nextInt(2)
      if(rand == 0) {
        nextMove = Paper
        largestSoFar = paperWins
      }
      else {
        nextMove = Scissors
        largestSoFar = scissorsWins
      }
    }

    if(paperWins > largestSoFar) {
      nextMove = Paper
      largestSoFar = paperWins
    }
    if(scissorsWins > largestSoFar) {
      nextMove = Scissors
      largestSoFar = scissorsWins
    }

    nextMove

  }
}
