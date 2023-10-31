package racingcar;

public class Car {

  private String name;
  private int forwardDistance;

  private Car() {
  }

  public Car(String name) {
    this.name = name;
    this.forwardDistance = 0;
  }

  public String getName() {
    return name;
  }

  public int getForwardDistance() {
    return forwardDistance;
  }

  public void addForwardDistance() {
    this.forwardDistance++;
  }

  public String getStatus() {
    StringBuilder status = new StringBuilder();
    status.append(this.getName()).append(" : ");

    for (int i = 0; i < this.forwardDistance; i++) {
      status.append("-");
    }

    return status.toString();
  }
}
