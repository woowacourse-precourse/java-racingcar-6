package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class RacingGame {
  private List<Car> cars;
  private int rounds;
  
  public RacingGame(List<String> carNames, int rounds) {
    this.cars = new ArrayList<>();
    for(String name : carNames) {
      this.cars.add(new Car(name));
    }
    this.rounds = rounds;
  }
  public void race() {
    for(int i=0; i<rounds; i++) {
      moveCars();
    }
  }
  
  private void moveCars() {
for(Car car : cars) {
      car.move();
    }
  }
  
  public List<String> getWinners() {
    int maxPosition = getMaxPosition();
    return cars.stream()
            .filter(car -> car.getPosition() ==maxPosition)
            .map(Car::getName)
            .collect(Collectors.toList());
  }
  
  private int getMaxPosition() {
    int maxPosition = 0;
    for(Car car : cars) {
        maxPosition = Math.max(maxPosition, car.getPosition());
    }
    return maxPosition;
  }
}
