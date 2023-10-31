package racingcar.controller;

import static racingcar.util.RacingCarGameUtils.convertStringToInt;
import static racingcar.util.RacingCarGameUtils.convertStringToList;
import static racingcar.view.InputView.getCarNamesFromPlayer;
import static racingcar.view.InputView.getNumberOfRoundsFromPlayer;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Cars;
import racingcar.view.OutputView;

public class RacingCarGame {

  public static RacingCarGame createRacingCarGame() {
    return new RacingCarGame();
  }

  public void run() {
    String inputCarName = getCarNamesFromPlayer();

    Cars cars = Cars.createFromCarNames(convertStringToList(inputCarName));

    int numberOfRounds = convertStringToInt(getNumberOfRoundsFromPlayer());

    OutputView.printRoundResultNotice();

    for (int i = 0; i < numberOfRounds; i++) {
      cars.playRacingGame();
      OutputView.printRoundResult(cars);
    }

    OutputView.printRacingCarGameWinner(cars);

    Console.close();
  }
}
