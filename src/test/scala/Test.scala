import PrimitiveDecider.PrimitiveDecider
import org.scalatest.flatspec.AnyFlatSpec

////to test correctness of beats method, we must test every possible case. Within the possible moves: rock, paper, scissors, we
////must try every combination of 2 possible. This results in 3^3 tests. After these tests, we must also test cases where there is
////one or more input that is invalid. After printing all these results we can see if there are any inconsistencies.

class Test extends AnyFlatSpec{
  "rock" should "beat scissors" in {
    assert(PrimitiveDecider.beats("rock", "scissors") == "true")
  }
  "rock" should "lose to paper" in {
    assert(PrimitiveDecider.beats("rock", "paper") == "false")
  }
  "rock" should "not lose nor win against rock" in {
    assert(PrimitiveDecider.beats("rock", "rock") == "undecided")
  }


  "paper" should "beat rock" in {
    assert(PrimitiveDecider.beats("paper", "rock") == "true")
  }
  "paper" should "lose to scissors" in {
    assert(PrimitiveDecider.beats("paper", "scissors") == "false")
  }
  "paper" should "not lose nor win against paper" in {
    assert(PrimitiveDecider.beats("paper", "paper") == "undecided")
  }


  "scissors" should "beat paper" in {
    assert(PrimitiveDecider.beats("scissors", "paper") == "true")
  }
  "scissors" should "lose to rock" in {
    assert(PrimitiveDecider.beats("scissors", "rock") == "false")
  }
  "scissors" should "not lose nor win against scissors" in {
    assert(PrimitiveDecider.beats("scissors", "scissors") == "undecided")
  }


  "invalid move" should "produce an error against rock" in {
    assert(PrimitiveDecider.beats("a", "rock") == "error")
  }
  "invalid move" should "produce an error against paper" in {
    assert(PrimitiveDecider.beats("a", "paper") == "error")
  }
  "invalid move" should "produce an error against scissors" in {
    assert(PrimitiveDecider.beats("a", "scissors") == "error")
  }

  "invalid move" should "produce an error against invalid move" in {
    assert(PrimitiveDecider.beats("a", "b") == "error")
  }


  "rock" should "produce an error against invalid move" in {
    assert(PrimitiveDecider.beats("rock", "a") == "error")
  }
  "paper" should "produce an error against invalid move" in {
    assert(PrimitiveDecider.beats("paper", "a") == "error")
  }
  "scissors" should "produce an error against invalid move" in {
    assert(PrimitiveDecider.beats("scissors", "a") == "error")
  }
}
