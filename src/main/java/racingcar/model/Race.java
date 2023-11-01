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

  public int getRandomValue() {
    int randomValue = Randoms.pickNumberInRange(0, 9);
    return randomValue;
  }

  public void startRace(int moveCount) {
    for (int move = 0; move < moveCount; move++) {
      int[] randomValues = new int[cars.size()];
      for (int i = 0; i < cars.size(); i++) {
        randomValues[i] = getRandomValue();
      }
      for(int i = 0; i<cars.size(); i++){
        Car car = cars.get(i);
        car.move(randomValues[i]);
      }
    }
  }

  public List<String> getWinners() {
    int maxPosition = 0;
    List<String> winners = new ArrayList<>();
    for (Car car : cars) {
      maxPosition = Math.max(maxPosition, car.getPosition());
    }
    for (Car car : cars) {
      if (car.getPosition() == maxPosition) {
        winners.add(car.getName());
      }
    }
    return winners;
  }
}
