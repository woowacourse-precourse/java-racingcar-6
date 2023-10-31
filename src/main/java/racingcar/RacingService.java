package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RacingService {
  void addDistance(Car car) {
    int randomNum = Randoms.pickNumberInRange(0, 9);
    int distance;

    if (randomNum > 4) {
      distance = 1;
    } else {
      distance = 0;
    }

    car.setDistance(distance);
  }

  List<Car> getWinner(List<Car> cars) {
    List<Car> winner = new ArrayList<>();
    List<Integer> carsDintance = new ArrayList<>();

    for (int i = 0; i < cars.size(); i++) {
      carsDintance.add(cars.get(i).getDistance());
    }

    int max = Collections.max(carsDintance);

    for (int i = 0; i < cars.size(); i++) {
      if (cars.get(i).getDistance() == max) {
        winner.add(cars.get(i));
      }
    }

    return winner;
  }
}
