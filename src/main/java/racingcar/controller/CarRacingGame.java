package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarRacingResult;
import racingcar.model.CarRacingWinner;
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
    if (carNames != null) {
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