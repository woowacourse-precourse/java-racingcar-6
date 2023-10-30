package racingcar.domain.car;

import racingcar.domain.formula.Formula;
import racingcar.domain.formula.MoveState;

public class Car {

  private static final int MAXIMUM_NAME_LENGTH = 5;

  private final String name;
  private int position;

  public Car(final String name, final int position) {
    validateName(name);
    this.name = name;
    this.position = position;
  }

  private void validateName(final String name) {
    isNameLengthValid(name);
  }

  private void isNameLengthValid(final String name) {
    if (name.isEmpty() || name.length() > MAXIMUM_NAME_LENGTH) {
      throw new IllegalArgumentException("이름은 1자 이상 5자 이하만 가능합니다.");
    }
  }

  public int move(final Formula formula) {
    if (formula.move() == MoveState.MOVING_FORWARD) {
      position++;
    }
    return position;
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }
}
