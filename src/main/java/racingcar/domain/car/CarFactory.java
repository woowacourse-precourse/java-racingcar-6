package racingcar.domain.car;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

  private static final int DEFAULT_POSITION = 0;

  public static List<Car> createCars(List<String> carNames) {
    return carNames.stream()
        .map(CarFactory::createCar)
        .collect(Collectors.toList());
  }

  private static Car createCar(String carName) {
    return new Car(carName, DEFAULT_POSITION);
  }
}
