package racingcar;

public class Referee {
  public String announceWinner(Game game){
      StringBuilder winners = new StringBuilder();
      int maxRace = 0;
      for (int i=0; i<game.players.length; i++){
          if(maxRace<game.players[i].location){
              maxRace=game.players[i].location;
          }
      }
      for (int i=0; i<game.players.length; i++){
          if(maxRace==game.players[i].location){
              winners.append(game.players[i].name);
          }
      }
      return String.valueOf(winners);
  }

}
