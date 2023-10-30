package racingcar.controller;

import static racingcar.util.ConvertUtils.convertStringToInt;
import static racingcar.util.ConvertUtils.convertStringToList;
import static racingcar.view.InputView.getCarNamesFromPlayer;
import static racingcar.view.InputView.getNumberOfRoundsFromPlayer;

import racingcar.model.Cars;
import racingcar.model.RacingCarGameConfig;

public class RacingCarGame {

  private final RacingCarGameConfig gameConfig;

  private RacingCarGame() {
    this.gameConfig = RacingCarGameConfig.createRacingCarGameConfig(5, 0, 9);
  }

  public static RacingCarGame createRacingCarGame() {
    return new RacingCarGame();
  }

  public void run() {
    String inputCarName = getCarNamesFromPlayer();

    Cars cars = Cars.createFromCarNames(convertStringToList(inputCarName));

    int numberOfRounds = convertStringToInt(getNumberOfRoundsFromPlayer());

    for (int i = 0; i < numberOfRounds; i++) {
      cars.playRacingGame();
    }

    printRacingCarGameWinner(cars);
  }

  private void printRacingCarGameWinner(Cars cars) {

  }
}
