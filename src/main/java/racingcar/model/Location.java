package racingcar.model;

public class Location {

  private Integer location = 0;

  public Location() {
  }

  public Location(Integer location) {
    this.location = location;
  }

  public void moveForward() {
    this.location++;
  }

  public Integer getLocation() {
    return location;
  }
}
