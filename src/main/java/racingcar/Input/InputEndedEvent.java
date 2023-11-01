package racingcar.Input;

public class InputEndedEvent {

  private final ValidatedCars validatedCars;
  private final ValidatedRoundCount validatedRoundCount;

  private InputEndedEvent(ValidatedCars validatedCars, ValidatedRoundCount validatedRoundCount) {
    this.validatedCars = validatedCars;
    this.validatedRoundCount = validatedRoundCount;
  }

  public static InputEndedEvent of(ValidatedCars validatedCars,
      ValidatedRoundCount validatedRoundCount) {
    return new InputEndedEvent(validatedCars, validatedRoundCount);
  }

  public RaceStartCommand startCommand() {
    return RaceStartCommand.of(validatedCars, validatedRoundCount);
  }
}
