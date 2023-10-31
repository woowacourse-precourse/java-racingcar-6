package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Referee;
import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class RaceGameService {
  private List<Car> cars = new ArrayList<>();

  public void initializeCars(String[] carNames) {
    for (String name : carNames) {
      cars.add(Car.createCar(name));
    }
  }

}
