package racingcar.model;

import racingcar.util.CarMoving;

public class Car {
  private final String name;
  private int moveCount;

  public Car(String carName) {
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
