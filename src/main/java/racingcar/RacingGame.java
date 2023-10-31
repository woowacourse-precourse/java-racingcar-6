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
    System.out.println("\n실행 결과");
    for(int i=0; i<rounds; i++) {
      moveCars();
      printCarsStatus();
      System.out.println();
    }
  }
  
  private void moveCars() {
    for(Car car : cars) {
      car.move();
    }
  }
  
  public void printCarsStatus() {
    for(Car car : cars) {
      car.printStatus();
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
