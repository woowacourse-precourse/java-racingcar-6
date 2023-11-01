package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class AwardService implements Award {

  @Override
  public List<String> getFinalWinners(List<Car> finalCars) {
    List<String> finalWinners = new ArrayList<>();

    int maxPosition = searchMaxPosition(finalCars);

    for (Car car : finalCars) {
      if (hasMaxPosition(car, maxPosition)) {
        finalWinners.add(car.getName());
      }
    }

    return finalWinners;
  }

  private int searchMaxPosition(List<Car> finalCars) {
    int maxPosition = finalCars.get(0).getPosition();

    for (Car car : finalCars) {
      int position = car.getPosition();
      maxPosition = Math.max(maxPosition, position);
    }

    return maxPosition;
  }

  private boolean hasMaxPosition(Car car, int maxPosition) {
    return car.getPosition() == maxPosition;
  }
}
