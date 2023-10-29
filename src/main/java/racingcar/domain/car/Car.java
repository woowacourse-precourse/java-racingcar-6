package racingcar.domain.car;

import racingcar.domain.formula.MoveFormula;
import racingcar.domain.formula.MoveState;

public class Car {

  private final String name;
  private int position;

  public Car(String name, int position) {
    this.name = name;
    this.position = position;
  }

  public synchronized int move(MoveFormula moveFormula) {
    if (moveFormula.move() == MoveState.GO) {
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
