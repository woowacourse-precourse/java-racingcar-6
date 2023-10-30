package racingcar.model;

import racingcar.validator.RacingCarNameValidator;

public class Car {

  static RacingCarNameValidator validator = new RacingCarNameValidator();

  private final String carName;
  private int location = 0;

  private Car(final String carName) {
    this.carName = carName;
  }

  public static Car from(final String carName) {
    validator.validate(carName);
    return new Car(carName);
  }

  public void move() {
    this.location++;
  }
}
