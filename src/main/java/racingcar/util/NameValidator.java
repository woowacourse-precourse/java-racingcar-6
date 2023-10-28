package racingcar.util;

import static racingcar.util.Constants.MAX_LENGTH;

import racingcar.message.ErrorMessages;

public class NameValidator implements Validate {
    @Override
    public void validate(String input) {
        if (input.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME.getMessage());
        }
    }
    public static NameValidator createNameValidator() {
    return new NameValidator();
    }

}
