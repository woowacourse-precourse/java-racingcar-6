package racingcar.IO.Input;

public class UnValidatedCars {

  private final String names;

  private UnValidatedCars(String names) {
    this.names = names;
  }

  public static UnValidatedCars of(String names) {
    return new UnValidatedCars(names);
  }

  public String getNames() {
    return names;
  }
}
