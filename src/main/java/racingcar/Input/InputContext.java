package racingcar.Input;

import static java.lang.System.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class InputContext {

  private InputContext() {
  }

  public static InputEndedEvent inputRacingCar() {
    out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    ValidatedCars validatedCars = inputRacingCarName();
    out.println("시도할 회수는 몇회인가요?");
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
        Arrays.stream(unValidated.split(",")).toList());
  }

  private static String input() {
    return Console.readLine();
  }
}
