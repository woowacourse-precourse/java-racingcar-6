package racingcar.IO.Input;

import java.util.List;

public class UnValidatedCars {
  private final List<String> names;

  private UnValidatedCars(List<String> names) {
    this.names = names;
  }

  public static UnValidatedCars of(List<String> names) {
    return new UnValidatedCars(names);
  }

  public List<String> getNames() {
    return names;
  }
}
