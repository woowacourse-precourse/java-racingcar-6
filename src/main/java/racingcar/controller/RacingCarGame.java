package racingcar.controller;

import static racingcar.util.ConvertUtils.convertStringToInt;
import static racingcar.util.ConvertUtils.convertStringToList;
import static racingcar.view.InputView.getCarNamesFromPlayer;
import static racingcar.view.InputView.getNumberOfRoundsFromPlayer;

import racingcar.model.Cars;

public class RacingCarGame {

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
