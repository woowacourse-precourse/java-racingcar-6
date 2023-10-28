package racingcar.model;

public class Car {
  private String name;
  private int forward;

  public Car(String name) {
    this.name = name;
    forward = 0;
  }

  public String getName() {
    return name;
  }

  public int getForward() {
    return forward;
  }

  public void increaseForward() {
    this.forward += 1;
  }
}
