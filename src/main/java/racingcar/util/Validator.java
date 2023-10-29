package racingcar.util;

public class Validator {

  private static final int MAX_CAR_NAME_LENGTH = 5;

  public static void CarNames(String input) {
    String[] carNames = input.split(",");

    for (String carName : carNames) {
      if (carName.trim().length() == 0 || carName.trim().length() > MAX_CAR_NAME_LENGTH) {
        throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
      }
    }
  }
}
