package racingcar.controller;


import java.util.List;
import racingcar.view.OutputView;
import racingcar.model.CarDistanceManager;

public class RacingCarGame {

  public void runRacing(List<String> carNamesList, List<Integer> distance, int frequency) {
    CarDistanceManager distanceManager = new CarDistanceManager();
    for (int i = 0; i < frequency; i++) {
      distanceManager.selectAction(distance);
      OutputView.printResultMessage(carNamesList, distance);
    }
  }


}
