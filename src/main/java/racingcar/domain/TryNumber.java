package racingcar.domain;

import static racingcar.message.InputErrorMessage.INPUT_TRY_NUMBER_TYPE_ERROR;

public class TryNumber {
  private final int tryNumber;

  public TryNumber(String tryNumber) {
    validateNumber(tryNumber);
    this.tryNumber = Integer.parseInt(tryNumber);
  }

  private void validateNumber(String input) {
    try {
      Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(INPUT_TRY_NUMBER_TYPE_ERROR.getMessage());
    }
  }

  public int getNumber() {
    return tryNumber;
  }
}

