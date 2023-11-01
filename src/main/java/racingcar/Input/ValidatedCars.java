package racingcar.Input;

import java.util.List;

public class ValidatedCars {

  private final List<String> names;

  private ValidatedCars(List<String> names) {
    this.names = names;
  }

  public static ValidatedCars of(UnValidatedCars unValidatedCars) {
    if (unValidatedCars.getNames().stream().anyMatch(name -> name.length() > 5 || name.isEmpty())) {
      throw new IllegalArgumentException("자동차 이름에 공백 또는 5자 이상의 문자가 포함되어 있습니다.");
    }
    return new ValidatedCars(unValidatedCars.getNames());
  }

  public List<String> getNames() {
    return names;
  }
}
