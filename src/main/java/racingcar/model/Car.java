package racingcar.model;

public class Car {
  private final CarName carName;
  private final Location location;

  private Car(final CarName carName, final Location location) {
    this.carName = carName;
    this.location = location;
  }

  public static Car from(final CarName carName, final Location location) {
    return new Car(carName, location);
  }

  public void move() {
    this.location.moveForward();
  }

  public String getCarInfo() {
    return String.format("%s : %s\n", this.carName.getCarName(),
        "-".repeat(Math.max(0, location.getLocation())));
  }

  public String getCarName() {
    return this.carName.getCarName();
  }

  public Integer getLocation() {
    return this.location.getLocation();
  }
}
