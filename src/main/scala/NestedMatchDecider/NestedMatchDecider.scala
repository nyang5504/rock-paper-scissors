package NestedMatchDecider

import benjamingarrett.rockpaperscissorstools.{AWins, BWins, Paper, RPSDecider, RPSMove, RPSOutcome, Rock, Scissors, Tie}

object NestedMatchDecider extends RPSDecider{
  override def beats(firstMove: RPSMove)(secondMove: RPSMove): RPSOutcome = firstMove match {
    case Rock => secondMove match {
      case Paper => BWins
      case Scissors => AWins
      case Rock => Tie
    }
    case Paper => secondMove match {
      case Rock => AWins
      case Scissors => BWins
      case Paper => Tie
    }
    case Scissors => secondMove match {
      case Rock => BWins
      case Paper => AWins
      case Scissors => Tie
    }
  }
}
