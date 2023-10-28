package racingcar.validator;

public class FrequencyValidator {

  public static void isCorrectFrequencyNumber(String frequency) throws IllegalArgumentException {
    for (char c : frequency.toCharArray()) {
      if (!Character.isDigit(c)) {
        throw new IllegalArgumentException("숫자를 입력해주세요.");
      }
    }
  }

  public static void isNegativeNumber(String frequency) throws IllegalArgumentException {
    if(Integer.parseInt(frequency) < 1) {
      throw new IllegalArgumentException("1보다 큰 수를 입력해주세요.");
    }
  }

}
