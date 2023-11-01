package racingcar.Input;

public class RaceStartCommand {

  private final ValidatedCars racingCars;
  private final ValidatedRoundCount roundCount;

  private RaceStartCommand(ValidatedCars racingCars, ValidatedRoundCount roundCount) {
    this.racingCars = racingCars;
    this.roundCount = roundCount;
  }

  public static RaceStartCommand of(ValidatedCars racingCars,
      ValidatedRoundCount racingCount) {
    return new RaceStartCommand(racingCars, racingCount);
  }

  public ValidatedCars getRacingCars() {
    return racingCars;
  }

  public ValidatedRoundCount getRoundCount() {
    return roundCount;
  }
}
