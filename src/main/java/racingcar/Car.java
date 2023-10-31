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
}
