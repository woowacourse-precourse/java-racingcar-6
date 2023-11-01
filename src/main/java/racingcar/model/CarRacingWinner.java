package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarRacingWinner {
  public static List<String> getWinners(List<Car> cars) {
    List<String> winners = new ArrayList<>();
    int resultCount = 0;

    for (Car car : cars) {
      int moveCount = car.getMoveCount();

      if (moveCount > resultCount) {
        resultCount = moveCount;

        winners.clear();
        winners.add(car.getName());
      } else if (moveCount == resultCount) {
        winners.add(car.getName());
      }
    }
    return winners;
  }
}
