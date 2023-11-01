package racingcar.validator;

import racingcar.constant.ErrorMessage;

public abstract class Validator {
    public abstract void validate(String inputString);

    // 공백인 경우
    static void validateEmptyInput(String carNames) {
        if (carNames.isBlank()) throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT_ERROR.getErrorMessage());
    }


}
