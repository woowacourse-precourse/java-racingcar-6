package racingcar.race;

import java.util.List;

public class RaceStartCommand {

  private final List<ValidatedRacingCar> racingCars;
  private final ValidationRoundCount roundCount;

  private RaceStartCommand(List<ValidatedRacingCar> racingCars, ValidationRoundCount roundCount) {
    this.racingCars = racingCars;
    this.roundCount = roundCount;
  }

  public static RaceStartCommand of(List<ValidatedRacingCar> racingCars,
      ValidationRoundCount racingCount) {
    return new RaceStartCommand(racingCars, racingCount);
  }

  public List<ValidatedRacingCar> getRacingCars() {
    return racingCars;
  }

  public ValidationRoundCount getRoundCount() {
    return roundCount;
  }
}
