package PrimitiveDecider
object PrimitiveDecider {
  def beats(move1: String, move2: String): String = {
    var possibleMoves = Array("rock", "paper", "scissors")
    if (!possibleMoves.contains(move1) || !possibleMoves.contains(move2)) {
      return "error"
    }
    else {
      if (move1 == "rock" && move2 == "paper") {
        return "false"
      }
      else if (move1 == "rock" && move2 == "scissors"){
        return "true"
      }
      else if (move1 == "rock" && move2 == "rock"){
        return "undecided"
      }
      else if (move1 == "paper" && move2 == "rock") {
        return "true"
      }
      else if (move1 == "paper" && move2 == "scissors"){
        return "false"
      }
      else if (move1 == "paper" && move2 == "paper"){
        return "undecided"
      }
      else if (move1 == "scissors" && move2 == "scissors"){
        return "undecided"
      }
      else if (move1 == "scissors" && move2 == "rock"){
        return "false"
      }
      else {
        return "true"
      }
    }

  }
}
