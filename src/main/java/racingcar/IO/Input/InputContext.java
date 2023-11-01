package racingcar.IO.Input;

import static java.lang.System.out;

import camp.nextstep.edu.missionutils.Console;

public class InputContext {

  private InputContext() {
  }

  public static InputEndedEvent inputRacingCar() {
    out.println(InputGuideMessage.GUIDE_CAR_NAME.getMessage());
    ValidatedCars validatedCars = inputRacingCarName();
    out.println(InputGuideMessage.GUIDE_ROUND_COUNT.getMessage());
    ValidatedRoundCount validatedRoundCount = inputRacingCount();
    return InputEndedEvent.of(validatedCars, validatedRoundCount);
  }

  private static ValidatedRoundCount inputRacingCount() {
    return ValidatedRoundCount.of(input());
  }

  private static ValidatedCars inputRacingCarName() {
    UnValidatedCars unValidatedCar = getUnValidatedCars();
    return ValidatedCars.of(unValidatedCar);
  }

  private static UnValidatedCars getUnValidatedCars() {
    return UnValidatedCars.of(input());
  }

  private static String input() {
    return Console.readLine();
  }
}
