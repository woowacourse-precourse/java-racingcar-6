package racingcar.IO.Input;

import static java.lang.System.out;
import static racingcar.IO.PunctuationMarks.COMMA;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

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
    String unValidated = input();
    return UnValidatedCars.of(
        Arrays.stream(unValidated.split(COMMA.mark())).toList());
  }

  private static String input() {
    return Console.readLine();
  }
}
