import benjamingarrett.rockpaperscissorstools.{RPSHistoryBasedPlayer, RPSTournament, RPSTournamentSeason}

class MixedTournamentSeason extends RPSTournamentSeason{
  override def handleTournamentSeason(players: List[RPSHistoryBasedPlayer])(tournaments: List[RPSTournament]): Map[RPSHistoryBasedPlayer, Int] = ???
}
