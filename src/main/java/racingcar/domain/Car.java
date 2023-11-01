package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

  private final String carName;
  private int position = 0;
  private static final int MOVE_THRESHOLD = 4;
  private static final int RANDOM_RANGE = 10;

  public Car(String carName) {
    this.carName = carName;
  }

  public Car(String carName, int position) {
    this.carName = carName;
    this.position = position;
  }

  public void moveForward() {
    int randomNumber = Randoms.pickNumberInRange(0, RANDOM_RANGE - 1);
    if (randomNumber >= MOVE_THRESHOLD) {
      position++;
    }
  }

  public int getPosition() {
    return this.position;
  }

  public String getCarName() {
    return this.carName;
  }
}
