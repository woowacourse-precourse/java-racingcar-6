package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Race {
  private List<Car> cars;

  public Race(List<Car> cars) {
    this.cars = cars;
  }


  public void startRace(int moveCount) {
    for (int move = 0; move < moveCount; move++) {
      for (Car car : cars) {
        car.move();
      }
    }
  }

  public List<Car> getWinners() {
    int maxPosition = 0;
    List<Car> winners = new ArrayList<>();
    for (Car car : cars) {
      maxPosition = Math.max(maxPosition, car.getPosition());
    }
    for (Car car : cars) {
      if (car.getPosition() == maxPosition) {
        winners.add(car);
      }
    }
    return winners;
  }
}
