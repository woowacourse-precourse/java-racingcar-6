package racingcar.validator;

import static racingcar.constant.ExceptionConstants.EMPTY_CAR_NAME;
import static racingcar.constant.ExceptionConstants.INVALID_SCOPE_NAME;
import static racingcar.constant.ExceptionConstants.UNALLOWED_SPECIAL_SYMBOL;

import org.junit.platform.commons.util.StringUtils;
import racingcar.constant.RacingCarGameConfig;
import racingcar.exception.RacingCarGameException;

public class RacingCarNameValidator implements Validator<String> {

  @Override
  public void validate(String data) {
    validateNull(data);
    validateLength(data);
    validateElement(data);
  }

  private void validateNull(String data) {
    if (StringUtils.isBlank(data)) {
      throw new RacingCarGameException(EMPTY_CAR_NAME);
    }
  }

  private void validateElement(final String data) {
    if (data.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*")) {
      throw new RacingCarGameException(UNALLOWED_SPECIAL_SYMBOL);
    }
  }

  private void validateLength(final String data) {
    if (data.length() > RacingCarGameConfig.CARNAME_MAXIMUM_LENGTH) {
      throw new RacingCarGameException(INVALID_SCOPE_NAME);
    }
  }

}
