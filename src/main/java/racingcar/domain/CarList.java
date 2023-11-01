package racingcar.domain;

import static racingcar.message.InputErrorMessage.INPUT_CAR_NAME_DUPLICATED_ERROR;

import java.util.List;
import racingcar.support.RandomNumberGenerator;

public class CarList {
  private final RandomNumberGenerator<Boolean> numberGenerator;
  private final List<Car> carList;

  public CarList(List<Car> cars) {
    this.numberGenerator = new CarMoveRandomGenerator();
    validateCarList(cars);
    this.carList = cars;
  }

  private void validateCarList(List<Car> cars) {
    if (isDuplicate(cars)) {
      throw new IllegalArgumentException(INPUT_CAR_NAME_DUPLICATED_ERROR.getMessage());
    }
  }

  private boolean isDuplicate(List<Car> cars) {
    long distinctCars = cars.stream()
            .distinct()
            .count();

    return cars.size() != distinctCars;
  }

  public void moveAll() {
    carList.stream()
            .filter(car -> isMove())
            .forEach(Car::move);
  }

  private boolean isMove() {
    return Boolean.TRUE.equals(numberGenerator.generateRandomNumber());
  }

  public List<Car> getCarList() {
    return carList;
  }
}
