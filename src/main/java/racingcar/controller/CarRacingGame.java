package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarRacingResult;
import racingcar.model.CarRacingWinner;
import racingcar.util.ValidationCarName;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {
  public void playGame() {
    List<Car> cars = new ArrayList<>();
    int movingCounts;

    OutputView.printSetCarName();
    String carNames = InputView.setCarName();

    if (ValidationCarName.isValidCarName(carNames)) {
      String[] carNameArray = carNames.split(",");
      for (String carName : carNameArray) {
        cars.add(new Car(carName.trim()));
      }
    }

    OutputView.printSetCount();
    movingCounts = InputView.setCount();

    CarRacingResult racingResult = new CarRacingResult();
    racingResult.startRace(cars, movingCounts);

    List<String> winners = CarRacingWinner.getWinners(cars);
    OutputView.printRaceWinner(winners);
  }
}