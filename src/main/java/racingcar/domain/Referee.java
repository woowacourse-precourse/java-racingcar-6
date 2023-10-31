package racingcar.domain;


import java.util.List;

public class Referee {

  public String judgementGameWon(List<Car> cars) {
    int maxProgress = getMaxProgress(cars);
    StringBuilder winners = new StringBuilder();
    for (Car car : cars) {
      if (car.getProgressCount() == maxProgress) {
        if (winners.length() > 0) {
          winners.append(", ");
        }
        winners.append(car.getCarName());
      }
    }
    return winners.toString();
  }

  private int getMaxProgress(List<Car> cars) {
    int max = 0;
    for (Car car: cars) {
      if (car.getProgressCount() > max) {
        max = car.getProgressCount();
      }
    }
    return max;
  }
}
