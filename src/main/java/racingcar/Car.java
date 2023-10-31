package racingcar;

public class Car {
  private String name;
  private Integer position;
  public Car(String name) {
    if (name.length() >= 5) throw new IllegalArgumentException();
    this.name = name;
    position = 0;
  }

  public Integer getPosition() {
    return position;
  }

  public String getName() {
    return name;
  }

  public void goForward() {
    this.position += 1;
  }

  @Override
  public String toString() {
    String status = "";
    for(int i = 0; i < position; i++)
      status += "-";
    return name + " : " + status;
  }
}
