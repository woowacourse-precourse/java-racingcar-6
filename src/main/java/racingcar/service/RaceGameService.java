package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Referee;

import java.util.ArrayList;
import java.util.List;

public class RaceGameService {
  private static List<Car> cars = new ArrayList<>();
  Referee referee = new Referee();

  public void initializeCars(String[] carNames) {
    for (String name : carNames) {
      cars.add(Car.createCar(name));
    }
  }
  public void race() {
    for (Car car : cars) {
      car.moveForwardCar();
    }
  }

  public static List<Car> getCars() {
    return cars;
  }

  public String getWinners() {
    return referee.judgementGameWon(cars);
  }

}
