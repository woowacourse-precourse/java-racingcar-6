package racingcar.model;

import java.util.List;

public class Cars {

  private List<Car> cars;

  private Cars(List<Car> cars) {
    this.cars = cars;
  }

  public static Cars createFromCarNames(List<String> carNames) {
    List<Car> carList = carNames.stream()
        .map(Car::from)
        .toList();
    return new Cars(carList);
  }

  public void playRacingGame() {
  }
}
