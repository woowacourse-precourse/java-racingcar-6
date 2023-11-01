package racingcar.IO.Input;

import static racingcar.IO.PunctuationMarks.*;

import java.util.Arrays;
import java.util.List;
import racingcar.IO.PunctuationMarks;

public class ValidatedCars {

  private final List<String> names;

  private ValidatedCars(List<String> names) {
    this.names = names;
  }

  public static ValidatedCars of(UnValidatedCars unValidatedCars) {
    List<String> unValidatedCarNames = getList(unValidatedCars);
    if (unValidatedCarNames.stream()
        .anyMatch(name -> name.length() > 5 || name.isEmpty() || name.isBlank())) {
      throw new IllegalArgumentException("자동차 이름에 공백 또는 5자 이상의 문자가 포함되어 있습니다.");
    }
    return new ValidatedCars(unValidatedCarNames);
  }

  private static List<String> getList(UnValidatedCars unValidatedCars) {
    return Arrays.stream(unValidatedCars.getNames().split(COMMA.mark())).toList();
  }

  public List<String> getNames() {
    return names;
  }
}
