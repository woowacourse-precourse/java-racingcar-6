package racingcar.utils;

public class ValidationUtils {

  public static void validateCarNames(String carNames) {
    String[] names = carNames.split(",");
    for (String name : names) {
      if (name.length() > 5) {
        throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
      }
    }
  }

  public static void validateUserInput(String userInput) {
    if (!userInput.matches("^[0-9]+$")) {
      throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
    }
  }
}
