package racingcar.util;

import static racingcar.util.Constants.BLANK;
import static racingcar.util.Constants.MAX_LENGTH;
import static racingcar.util.Constants.NULL;

import java.util.Objects;
import racingcar.message.ErrorMessages;

public class ValidateImpl implements Validate{
    public static void validateName(String input) {
        ValidateImpl validateImpl = new ValidateImpl();
        validateImpl.blankValidator(input);
        validateImpl.nullValidator(input);
        validateImpl.MaxLengthValidator(input);
    }
    @Override
    public void blankValidator(String input) {
        if (input.contains(BLANK)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME_BLANK.getMessage());
        }
    }

    @Override
    public void nullValidator(String input) {
        if(Objects.equals(input, NULL)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME.getMessage());
        }
    }

    @Override
    public void MaxLengthValidator(String input) {
        if (input.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME.getMessage());
        }
    }
}
