package racingcar.model;

import racingcar.util.CarMoving;
import racingcar.util.ValidationCarName;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Car {
  private final String name;
  private int moveCount;

  public Car(String carName) {
    if(!ValidationCarName.isValidCarName(carName)) {
      throw new IllegalArgumentException();
    }

    this.name = carName;
    this.moveCount = 0;
  }

  public String getName() {
    return name;
  }

  public void move() {
    if (CarMoving.move()) {
      moveCount++;
    }
  }

  public int getMoveCount() {
    return moveCount;
  }
}
