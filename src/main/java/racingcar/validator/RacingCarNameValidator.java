package racingcar.validator;

import static racingcar.constant.ExceptionConstants.INVALID_SCOPE_NAME;
import static racingcar.constant.ExceptionConstants.UNALLOWED_SPECIAL_SYMBOL;

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
      throw new RacingCarGameException(UNALLOWED_SPECIAL_SYMBOL);
    }
  }

  private void validateLength(final String data) {
    if (data.length() > RacingCarGameConfig.CARNAME_MAXIMUM_LENGTH || data.isBlank()) {
      throw new RacingCarGameException(INVALID_SCOPE_NAME);
    }
  }

}
