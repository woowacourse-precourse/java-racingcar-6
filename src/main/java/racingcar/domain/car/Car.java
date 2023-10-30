package racingcar.domain.car;

import racingcar.domain.formula.Formula;
import racingcar.domain.formula.MoveState;

public class Car {

  private final String name;
  private int position;

  public Car(String name, int position) {
    this.name = name;
    this.position = position;
  }

  public synchronized int move(Formula formula) {
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
