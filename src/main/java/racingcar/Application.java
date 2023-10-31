package racingcar;

import java.util.List;

public class Application {
  public static void main(String[] args) {
    List<String> carNames = UserInput.getCarNamesFromUser();
    int rounds = UserInput.getRoundsFromUser();
    
    RacingGame racingGame = new RacingGame(carNames, rounds);
    racingGame.race();
    
    System.out.print("최종 우승자 : " + String.join(", ", racingGame.getWinners()));
  }
}
