package racingcar.domain.car;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

  private static final int DEFAULT_POSITION = 0;

  public static List<Car> createCars(List<String> carNames) {
    validateCars(carNames);
    return carNames.stream()
        .map(CarFactory::createCar)
        .collect(Collectors.toList());
  }

  private static void validateCars(List<String> carNames) {
    isDistinct(carNames);
  }

  private static void isDistinct(List<String> carNames) {
    int distinctCount = (int) carNames.stream()
        .distinct()
        .count();
    if (distinctCount != carNames.size()) {
      throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
    }
  }

  private static Car createCar(String carName) {
    return new Car(carName, DEFAULT_POSITION);
  }
}
