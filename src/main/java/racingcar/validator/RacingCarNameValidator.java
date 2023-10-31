package racingcar.validator;

import racingcar.exception.RacingCarGameException;
import racingcar.model.RacingCarGameConfig;

public class RacingCarNameValidator implements Validator<String> {

  @Override
  public void validate(String data) {
    validateLength(data);
    validateElement(data);
  }

  private void validateElement(final String data) {
    if (data.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*")) {
      throw new RacingCarGameException("문자열에 특수 문자가 포함되어 있습니다.");
    }
  }

  private void validateLength(final String data) {
    if (data.length() > RacingCarGameConfig.CARNAME_MAXIMUM_LENGTH || data.isBlank()) {
      throw new RacingCarGameException("자동차 이름은 1~5자 이여야 합니다.");
    }
  }

}
