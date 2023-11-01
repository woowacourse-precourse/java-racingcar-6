package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
  public void printCarStatus(List<Car> cars) {
    for (Car car : cars) {
      String movement = car.getMovement();
      System.out.println(car.getName() + " : " + movement);
    }
  }

  public void printWinners(List<Car> winners) {
    if (winners.isEmpty()) {
      System.out.println("최종 우승자: 없음");
    } else {
      StringBuilder winnerNames = new StringBuilder();
      for (Car winner : winners) {
        if (winnerNames.length() > 0) {
          winnerNames.append(", ");
        }
        winnerNames.append(winner.getName());
      }
      System.out.println("최종 우승자 : " + winnerNames.toString());
    }
  }
}

