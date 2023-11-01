package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;
import java.util.ArrayList;

public class GameController {
  private Input input;
  private Output output;
  private Cars racingCars;

  public GameController() {
    this.input = new Input();
    this.output = new Output();
    List<String> carNames = input.inputCarNames();
    List<Car> cars = createCars(carNames);
    this.racingCars = new Cars(cars);
  }

  public void runGame() {
    int attempts = input.inputTryCount();

    for (int i = 0; i < attempts; i++) {
      racingCars.moveCars();
      output.printCurrentPositions(racingCars.getCarNames(), racingCars.getCarPositions());
    }

    List<String> winners = determineWinners(racingCars.getCarNames(), racingCars.getCarPositions());
    output.printFinalWinners(winners);
  }

  private List<String> determineWinners(List<String> carNames, List<Integer> carPositions) {
    List<String> winners = new ArrayList<>();
    int maxPosition = 0;
    for (int position : carPositions) {
      maxPosition = Math.max(maxPosition, position);
    }
    for (int i = 0; i < carPositions.size(); i++) {
      if (carPositions.get(i) == maxPosition) {
        winners.add(carNames.get(i));
      }
    }
    return winners;
  }

  private List<Car> createCars(List<String> carNames) {
    List<Car> cars = new ArrayList<>();
    for (String name : carNames) {
      cars.add(new Car(name));
    }
    return cars;
  }
}
