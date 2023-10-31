package racingcar.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Cars {

  private final List<Car> cars;

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public List<String> getCarNames() {
    List<String> carNames = new ArrayList<>();
    for (Car car : cars) {
      carNames.add(car.getCarName());
    }
    return carNames;
  }

  public List<Integer> getCarPositions() {
    List<Integer> carPositions = new ArrayList<>();
    for (Car car : cars) {
      carPositions.add(car.getPosition());
    }
    return carPositions;
  }

  public void moveCars() {
    for (Car car : cars) {
      car.moveForward();
    }
  }
}
