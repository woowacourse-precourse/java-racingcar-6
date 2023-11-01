package racingcar.model;

import racingcar.validator.RacingCarNameValidator;

public class CarName {
  RacingCarNameValidator validator = new RacingCarNameValidator();

  private final String carName;

  public CarName(String carName) {
    validator.validate(carName);
    this.carName = carName;
  }

  public String getCarName() {
    return carName;
  }
}
