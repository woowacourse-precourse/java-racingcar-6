package racingcar;

public class Race {
  private Car[] cars;

  public Race(String[] carNames) {
    cars = new Car[carNames.length];
    for (int i = 0; i < carNames.length; i++) {
      cars[i] = new Car(carNames[i]);
    }
  }

  public void race() {
    for (Car car : cars) {
      car.move();
    }
  }

  public Car[] getCars() {
    return cars;
  }
}
