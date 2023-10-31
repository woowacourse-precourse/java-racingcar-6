package racingcar.model;

import static racingcar.constant.RacingCarGameConfig.GAME_WIN_CONDITION;
import static racingcar.util.RacingCarGameUtils.generateRandomValuesForCarGame;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Cars {

  private final List<Car> cars;

  private Cars(final List<Car> cars) {
    this.cars = cars;
  }

  public static Cars createFromCarNames(final List<String> carNames) {
    List<Car> carList = carNames.stream()
        .map(Car::from)
        .toList();
    return new Cars(carList);
  }

  public void playRacingGame() {
    List<Integer> randomValues = generateRandomValuesForCarGame(cars.size());
    for (int i = 0; i < cars.size(); i++) {
      moveCarByRandomValues(randomValues, i);
    }
  }

  private void moveCarByRandomValues(final List<Integer> randomValues, final Integer i) {
    if (randomValues.get(i) >= GAME_WIN_CONDITION) {
      cars.get(i).move();
    }
  }

  public String getWinnerByDistance() {
    int maxDistance = this.cars.stream()
        .mapToInt(Car::getLocation)
        .max()
        .orElse(0);
    List<Car> winners = this.cars.stream()
        .filter(car -> car.getLocation() == maxDistance)
        .toList();

    List<String> winnerList = new ArrayList<>();
    for (Car winner : winners) {
      winnerList.add(winner.getCarName());
    }

    return generateWinnerFormat(winnerList);
  }

  private String generateWinnerFormat(final List<String> winnerList) {
    if (winnerList.size() == 1) {
      return winnerList.get(0);
    }

    StringJoiner joiner = new StringJoiner(", ");
    for (String index : winnerList) {
      joiner.add(index);
    }
    return joiner.toString();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Car car : cars) {
      sb.append(car.getCarInfo());
    }
    return sb.toString();
  }


}

