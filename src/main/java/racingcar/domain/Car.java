package racingcar.domain;

public class Car {

  private String name;
  private int progress;

  public Car(String name) {
    this.name = name;
    this.progress = 0;
  }

  public Car(String name, int progress) {
    this.name = name;
    this.progress = progress;
  }

  public void move() {
    this.progress += 1;
  }

  public String getName() {
    return this.name;
  }

  public int getProgress() {
    return this.progress;
  }
}
