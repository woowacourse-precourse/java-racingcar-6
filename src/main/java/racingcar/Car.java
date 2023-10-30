package racingcar;

public class Car {
  private Car() {}

  public Car(String name) {
    this.name = name;
    this.forwardDistance = 0;
  }

  private String name;
  private int forwardDistance;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getForwardDistance() {
    return forwardDistance;
  }

  public void setForwardDistance(int forwardDistance) {
    this.forwardDistance = forwardDistance;
  }

  public void addForwardDistance() {
    this.forwardDistance++;
  }
}
