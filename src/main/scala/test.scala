import PrimitiveDecider.PrimitiveDecider

//to test correctness of beats method, we must test every possible case. Within the possible moves: rock, paper, scissors, we
//must try every combination of 2 possible. This results in 3^3 tests. After these tests, we must also test cases where there is
//one or more input that is invalid. After printing all these results we can see if there are any inconsistencies.
object test extends App {
  println("Does rock beat paper? " + PrimitiveDecider.beats("rock","paper"))
  println("Does rock beat scissors? " + PrimitiveDecider.beats("rock","scissors"))
  println("Does rock beat rock? " + PrimitiveDecider.beats("rock","rock"))
  println("Does paper beat scissors? " + PrimitiveDecider.beats("paper","scissors"))
  println("Does paper beat rock? " + PrimitiveDecider.beats("paper","rock"))
  println("Does paper beat paper? " + PrimitiveDecider.beats("paper","paper"))
  println("Does scissors beat rock? " + PrimitiveDecider.beats("scissors","rock"))
  println("Does scissors beat paper? " + PrimitiveDecider.beats("scissors","paper"))
  println("Does scissors beat scissors? " + PrimitiveDecider.beats("scissors","scissors"))
  println("Does a beat rock? " + PrimitiveDecider.beats("a","rock"))
  println("Does a beat paper? " + PrimitiveDecider.beats("a","paper"))
  println("Does a beat scissors? " + PrimitiveDecider.beats("a","scissors"))
  println("Does rock beat a? " + PrimitiveDecider.beats("rock","a"))
  println("Does paper beat a? " + PrimitiveDecider.beats("paper","a"))
  println("Does scissors beat a? " + PrimitiveDecider.beats("scissors","a"))
  println("Does a beat b? " + PrimitiveDecider.beats("a","b"))
}
