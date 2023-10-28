package racingcar.validator;

public class FrequencyValidator {

  public void isCorrectFrequencyNumber(String frequency) throws IllegalArgumentException {
    for (char c : frequency.toCharArray()) {
      if (!Character.isDigit(c)) {
        throw new IllegalArgumentException("숫자를 입력해주세요.");
      }
    }
  }



}
