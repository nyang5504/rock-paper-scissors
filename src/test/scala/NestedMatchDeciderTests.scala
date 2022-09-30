import org.scalatest.flatspec.AnyFlatSpec
import NestedMatchDecider.NestedMatchDecider
import benjamingarrett.rockpaperscissorstools.{AWins, BWins, Paper, RPSMove, RPSOutcome, Rock, Scissors, Tie}

import scala.collection.IterableOnce.iterableOnceExtensionMethods

class NestedMatchDeciderTests extends AnyFlatSpec {

  val movesAndResultsMap: Map[(RPSMove,RPSMove),RPSOutcome] =
    Map.apply((Rock,Paper) -> BWins, (Rock, Scissors) -> AWins, (Rock,Rock) -> Tie,
      (Paper,Scissors) -> BWins, (Paper, Rock) -> AWins, (Paper,Paper) -> Tie,
      (Scissors,Rock) -> BWins, (Scissors, Paper) -> AWins, (Scissors,Scissors) -> Tie)

  assert(movesAndResultsMap.map { case (moves, expected) => NestedMatchDecider.beats(moves._1)(moves._2) == expected}.forall(_==true))

//  "rock" should "beat scissors" in {
//    assert(NestedMatchDecider.beats(Rock)(Scissors) == AWins)
//  }
//  "rock" should "lose to paper" in {
//    assert(NestedMatchDecider.beats(Rock)(Paper) == BWins)
//  }
//  "rock" should "not lose nor win against rock" in {
//    assert(NestedMatchDecider.beats(Rock)(Rock) == Tie)
//  }
//
//
//  "Paper" should "beat Rock" in {
//    assert(NestedMatchDecider.beats(Paper)(Rock) == AWins)
//  }
//  "Paper" should "lose to Scissors" in {
//    assert(NestedMatchDecider.beats(Paper)(Scissors) == BWins)
//  }
//  "Paper" should "not lose nor win against Paper" in {
//    assert(NestedMatchDecider.beats(Paper)(Paper) == Tie)
//  }
//
//
//  "Scissors" should "beat Paper" in {
//    assert(NestedMatchDecider.beats(Scissors)(Paper) == AWins)
//  }
//  "Scissors" should "lose to Rock" in {
//    assert(NestedMatchDecider.beats(Scissors)(Rock) == BWins)
//  }
//  "Scissors" should "not lose nor win against Scissors" in {
//    assert(NestedMatchDecider.beats(Scissors)(Scissors) == Tie)
//  }
}
