package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

  private final String carName;
  private int position = 0;

  public Car(String carName) {
    this.carName = carName;
  }

  public Car(String carName, int position) {
    this.carName = carName;
    this.position = position;
  }

  public void moveForward() {
    int randomNumber = Randoms.pickNumberInRange(0, 9);
    if (randomNumber >= 4) {
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
