package racingcar.domain;

public class Car {

  public final int MAX_NAME_LENGTH = 5;

  private String name;
  private int progress;

  public Car(String name) {
    this(name, 0);
  }

  public Car(String name, int progress) {
    validateCar(name, progress);
    this.name = name;
    this.progress = progress;
  }

  public void validateCar(String name, int progress) {
    if (name.length() > MAX_NAME_LENGTH) {
      throw new IllegalArgumentException();
    }
    if (name.isBlank()) {
      throw new IllegalArgumentException();
    }
    if (progress < 0) {
      throw new IllegalArgumentException();
    }
  }

  public void move() {
    this.progress += 1;
  }

  public boolean isWinner(int maxPoint) {
    return (this.progress == maxPoint);
  }

  public String getName() {
    return this.name;
  }

  public int getProgress() {
    return this.progress;
  }
}
