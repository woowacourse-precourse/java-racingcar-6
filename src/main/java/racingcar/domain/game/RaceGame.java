package racingcar.domain.game;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.formula.Formula;

public class RaceGame {

  private final int MINIMUM_ROUND = 1;

  private final List<Car> cars;
  private final Formula formula;
  private int round;

  public RaceGame(final Formula formula, final List<Car> cars, final int round) {
    validateRound(round);
    this.formula = formula;
    this.cars = cars;
    this.round = round;
  }

  private void validateRound(final int round) {
    isRoundPositive(round);
  }

  private void isRoundPositive(final int round) {
    if (round < MINIMUM_ROUND) {
      throw new IllegalArgumentException("시도할 회수는 1 이상이어야 합니다.");
    }
  }

  public void race(final Consumer<List<RaceGameResult>> consumer) {
    while (round >= MINIMUM_ROUND) {
      List<RaceGameResult> raceResults = cars.stream()
          .map(car -> new RaceGameResult(car.getName(), car.move(formula)))
          .collect(Collectors.toList());
      consumer.accept(raceResults);
      round--;
    }
  }

  public List<String> currentHeadOfRace() {
    int maxPosition = cars.stream()
        .mapToInt(Car::getPosition)
        .max()
        .orElse(0);
    return cars.stream()
        .filter(car -> car.getPosition() == maxPosition)
        .map(Car::getName)
        .toList();
  }
}
