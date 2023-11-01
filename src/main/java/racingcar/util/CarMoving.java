package racingcar.util;

import racingcar.model.RandomNumber;

public class CarMoving {
  public static boolean move() {
    RandomNumber generateRandomNumber = new RandomNumber();

    int randomNumber = generateRandomNumber.getNumber();
    return randomNumber >= 4;
  }
}
