package racingcar.validator;

import static racingcar.message.InputErrorMessage.INPUT_CAR_NAME_LENGTH_ERROR;
import static racingcar.message.InputErrorMessage.INPUT_CAR_NAME_NULL_ERROR;

import org.junit.platform.commons.util.StringUtils;

public class CarNameValidator {
  private static final int CAR_NAME_LENGTH = 5;

  public static void validateLength(String name) {
    if (name.length() > CAR_NAME_LENGTH) {
      throw new IllegalArgumentException(INPUT_CAR_NAME_LENGTH_ERROR.getMessage());
    }

    if (StringUtils.isBlank(name)) {
      throw new IllegalArgumentException(INPUT_CAR_NAME_NULL_ERROR.getMessage());
    }
  }
}