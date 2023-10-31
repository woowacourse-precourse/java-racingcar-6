package racingcar;

import java.util.List;

public class CarView {
  public void printStatus(List<Car> cars) {
    for (Car car : cars) {
      System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }
  }

  public void printWinners(List<String> winners) {
    System.out.println("최종 우승자 : " + String.join(", ", winners));
  }
}
