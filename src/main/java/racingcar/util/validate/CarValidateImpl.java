package racingcar.util;

import static racingcar.util.Constants.BLANK;
import static racingcar.util.Constants.MAX_LENGTH;
import static racingcar.util.Constants.NULL;

import java.util.Arrays;
import java.util.Objects;
import racingcar.message.ErrorMessages;

public class CarValidateImpl implements CarValidate {
    public CarValidateImpl(String input) {
        blankValidator(input);
        nullValidator(input);
        MaxLengthValidator(input);
    }

    public static void createVaule(String input) {
        new CarValidateImpl(input);
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
