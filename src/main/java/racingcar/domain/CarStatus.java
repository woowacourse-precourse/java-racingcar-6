package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CarStatus {

  private static final String MOVE_POSITION = "-";
  private static final String CAR_MOVE_RESULT = " : ";
  private final Map<String, Integer> carPositions;

  public CarStatus(List<Car> cars) {
    carPositions = new HashMap<>();
    for (Car car : cars) {
      carPositions.put(car.getName(), car.getPosition());
    }
  }

  public String toRacingLog() {
    StringBuilder racingLog = new StringBuilder();

    for (Entry<String, Integer> entry : carPositions.entrySet()) {
      String carName = entry.getKey();
      int currentPosition = entry.getValue();

      StringBuilder positionString;
      positionString = new StringBuilder();
      positionString.append(MOVE_POSITION.repeat(Math.max(0, currentPosition)));

      racingLog.append(carName).append(CAR_MOVE_RESULT).append(positionString).append(System.lineSeparator());
    }

    return racingLog.toString();
  }

  public int getMaxPosition() {
    return carPositions.values().stream().mapToInt(Integer::intValue).max().orElse(0);
  }

  public List<String> getCarNamesAtPosition(int position) {
    return carPositions.entrySet().stream()
            .filter(entry -> entry.getValue() == position)
            .map(Entry::getKey)
            .collect(Collectors.toList());
  }
}
