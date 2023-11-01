package racingcar.controller;

import racingcar.view.Input;
import racingcar.view.Output;
import racingcar.domain.Cars;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class GameController {

  private final Input input;
  private final Output output;
  private Cars racingCars;

  public GameController(Input input, Output output) {
    this.input = input;
    this.output = output;
  }

  public void runGame() {
    initializeGame();
    Round round = new Round(racingCars, output);

    int attempts = input.inputTryCount();
    for (int i = 0; i < attempts; i++) {
      round.play();
    }

    showWinners();
  }

  private void initializeGame() {
    List<String> carNames = input.inputCarNames();
    List<Car> cars = createCars(carNames);
    this.racingCars = new Cars(cars);
  }

  private List<String> determineWinners() {
    List<String> winners = new ArrayList<>();
    int maxPosition = getMaxPosition();
    for (int i = 0; i < racingCars.getCarPositions().size(); i++) {
      if (racingCars.getCarPositions().get(i) == maxPosition) {
        winners.add(racingCars.getCarNames().get(i));
      }
    }
    return winners;
  }

  private int getMaxPosition() {
    List<Integer> carPositions = racingCars.getCarPositions();
    int max = 0;
    for (int position : carPositions) {
      max = Math.max(max, position);
    }
    return max;
  }

  private List<Car> createCars(List<String> carNames) {
    List<Car> cars = new ArrayList<>();
    for (String name : carNames) {
      cars.add(new Car(name));
    }
    return cars;
  }

  private void showWinners() {
    List<String> winners = determineWinners();
    output.printFinalWinners(winners);
  }
}
