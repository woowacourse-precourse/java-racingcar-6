package racingcar.view;

import java.util.List;
import java.util.stream.Stream;

public record RaceGameInput(List<String> carNames, int round) {

  private static final String DELIMITER = ",";
  private static final int MAX_CAR_NAME_LENGTH = 5;

  public static RaceGameInput from(String carNamesInput, String roundInput) {
    validateCarNamesInput(carNamesInput);
    validateRoundInput(roundInput);
    return new RaceGameInput(List.of(carNamesInput.split(DELIMITER)), Integer.parseInt(roundInput));
  }

  private static void validateCarNamesInput(String carNamesInput) {
    isInputEmpty(carNamesInput);
    startOrEndsWithDelimiter(carNamesInput);
    isDistinct(carNamesInput);
    isEachCarNameLengthValid(carNamesInput);
  }

  private static void isInputEmpty(String input) {
    if (input.isEmpty()) {
      throw new IllegalArgumentException("입력값이 비어있습니다.");
    }
  }

  private static void startOrEndsWithDelimiter(String input) {
    if (input.startsWith(DELIMITER) || input.endsWith(DELIMITER)) {
      throw new IllegalArgumentException("자동차 이름은 쉼표로 시작하거나 끝날 수 없습니다.");
    }
  }

  private static void isDistinct(String input) {
    String[] carNames = input.split(DELIMITER);
    int distinctCount = (int) Stream.of(carNames).distinct().count();
    if (distinctCount != carNames.length) {
      throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
    }
  }

  private static void isEachCarNameLengthValid(String input) {
    String[] carNames = input.split(DELIMITER);
    for (String carName : carNames) {
      isCarNameLengthValid(carName);
    }
  }

  private static void isCarNameLengthValid(String carName) {
    if (carName.length() > MAX_CAR_NAME_LENGTH) {
      throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
    }
  }

  private static void validateRoundInput(String roundInput) {
    isNumeric(roundInput);
  }

  private static void isNumeric(String input) {
    try {
      Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
    }
  }
}
