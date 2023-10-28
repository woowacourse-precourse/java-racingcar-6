package racingcar.controller;


import static racingcar.controller.CarNameParser.carNameToList;

import java.util.List;
import racingcar.view.OutputView;
import racingcar.view.InputView;
import racingcar.model.CarDistanceManager;
import racingcar.model.GameResultAnalyzer;
import racingcar.controller.CarNameParser;

public class RacingCarGame {

  private static CarNameParser carNameParser;
  private static CarDistanceManager carDistanceManager;
  private static GameResultAnalyzer gameResultAnalyzer;
  private static InputView inputView;

  public RacingCarGame() {
    inputView = new InputView();
    carNameParser = new CarNameParser();
    carDistanceManager = new CarDistanceManager();
    gameResultAnalyzer = new GameResultAnalyzer();
  }

  public static void runRacing(List<String> carNamesList, List<Integer> distance, int frequency) {
    CarDistanceManager distanceManager = new CarDistanceManager();
    for (int i = 0; i < frequency; i++) {
      distanceManager.selectAction(distance);
      OutputView.printResultMessage(carNamesList, distance);
    }
  }

  public static void racingCarGame() {
    String carNames = inputView.inputCarName();
    String[] carNamesArray = carNameParser.carNamesToArray(carNames);
    List<String> carNamesList = carNameToList(carNamesArray);
    int frequency = inputView.inputFrequency();
    OutputView.printFirstResultMessage();
    List<Integer> distance = carDistanceManager.carDistance(carNamesList);
    runRacing(carNamesList, distance, frequency);
    int max = gameResultAnalyzer.findMaxDistance(distance);
    List<Integer> winner = gameResultAnalyzer.selectWinner(distance, max);
    OutputView.printWinner(winner, carNamesList);
  }
}
