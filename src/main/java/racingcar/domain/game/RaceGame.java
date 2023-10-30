package racingcar.domain.game;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.formula.Formula;

public class RaceGame {

  private final int MINIMUM_ROUND = 0;

  private final List<Car> cars;
  private final Formula formula;
  private int round;

  public RaceGame(Formula formula, List<Car> cars, int round) {
    validateCarCount(cars);
    validateRound(round);
    this.formula = formula;
    this.cars = cars;
    this.round = round;
  }

  private void validateCarCount(List<Car> cars) {
    if (cars.isEmpty()) {
      throw new IllegalArgumentException("자동차는 1대 이상이어야 합니다.");
    }
  }

  private void validateRound(int round) {
    isRoundPositive(round);
  }

  private void isRoundPositive(int round) {
    if (round < MINIMUM_ROUND) {
      throw new IllegalArgumentException("시도 회수는 0 이상이어야 합니다.");
    }
  }

  public synchronized void race(Consumer<List<RaceGameResult>> raceResultProcess) {
    while (round > MINIMUM_ROUND) {
      List<RaceGameResult> raceResults = cars.stream()
          .map(car -> new RaceGameResult(car.getName(), car.move(formula)))
          .collect(Collectors.toList());
      raceResultProcess.accept(raceResults);
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
