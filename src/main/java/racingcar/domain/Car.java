package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Car {

  RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
  private static final int MOVE_THRESHOLD = 4;
  private String name;
  private int progressCount;

  public Car(String name) {
    this.name = name;
    this.progressCount = 0;
  }

  public boolean moveForwardCar() {
    int randomNumber = randomNumberGenerator.generateUniqueNumbers();
    if (randomNumber >= MOVE_THRESHOLD) {
      this.progressCount++;
    }
    return stopCar();
  }

  public boolean stopCar() {
    return false;
  }

  public static Car createCar(String name) {
    return new Car(name);
  }
  public String getCarName() {
    return this.name;
  }

  public int getProgressCount() {
    return this.progressCount;
  }

}
