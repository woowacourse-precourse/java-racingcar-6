package racingcar.util;

import static racingcar.util.Constants.BLANK;

import racingcar.message.ErrorMessages;

public class BlankValidator implements Validate {


    @Override
    public void validate(String input) {
        if (input.contains(BLANK)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME_BLANK.getMessage());
        }
    }
    public static BlankValidator createBlankValidator() {
        return new BlankValidator();
    }
}
