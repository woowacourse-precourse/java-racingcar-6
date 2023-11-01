package racingcar.model;

import java.util.List;
import racingcar.view.OutputView;

public class CarRacingResult {
  public void startRace(List<Car> cars, int movingCounts) {
    OutputView.printStartRacing();

    for (int count = 0; count < movingCounts; count++) {
      for (Car car : cars) {
        car.move();
        OutputView.printRaceResult(car.getName(), car.getMoveCount());
      }
      System.out.println();
    }
  }
}
