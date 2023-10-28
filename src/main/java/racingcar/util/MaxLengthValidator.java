package racingcar.util;

import racingcar.message.ErrorMessages;

public class MaxLengthValidator implements Validate{
    public static MaxLengthValidator createMaxLengthValidator() {
        return new MaxLengthValidator();
    }
    @Override
    public void validate(String input) {
        throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME_LENGTH.getMessage());
    }

}