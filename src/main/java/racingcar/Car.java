package racingcar;

public class Car {
  // 멤버변수
  private String name;
  private int distance;

  // 생성자
  Car(String name) {
    this.name = name;
    this.distance = 0;
  }

  public String getName() {
    return name;
  }

  public Integer getDistance() {
    return distance;
  }

  public void setDistance(int distance) {
    this.distance += distance;
  }
}
