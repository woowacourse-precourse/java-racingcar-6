package racingcar.domain;

import java.util.Objects;
import racingcar.validator.CarNameValidator;

public class Car {
  private final String name;

  private int position = 0;

  public Car(String name) {
    String refined = name.trim();
    CarNameValidator.validateLength(refined);
    this.name = refined;
  }

  public void move() {
    position++;
  }

  public int getPosition() {
    return position;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Car otherCar = (Car) o;

    return Objects.equals(name, otherCar.name);
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }
}
