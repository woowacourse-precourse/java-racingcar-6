package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
  private String name;
  private int position;

  public Car(String name) {
    this.name = name;
    this.position = 0;
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }

  public int getRandomValue() {
    return Randoms.pickNumberInRange(0, 9);
  }

  public void move() {
    int randomValue = getRandomValue();
    if (randomValue >= 4) {
      position++;
    }
    System.out.println(name + ": " + randomValue);
  }

  public String getMovement() {
    StringBuilder movement = new StringBuilder();
    for (int i = 0; i < position; i++) {
      movement.append("-");
    }
    return movement.toString();
  }
}
