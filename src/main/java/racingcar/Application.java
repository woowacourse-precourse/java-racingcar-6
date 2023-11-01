package racingcar;

import racingcar.controller.RacingCarGame;

public class Application {

  public static void main(String[] args) {
    RacingCarGame game = RacingCarGame.createRacingCarGame();
    game.run();
  }
}
