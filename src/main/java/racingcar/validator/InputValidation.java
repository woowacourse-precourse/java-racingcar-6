package racingcar.validator;

import java.util.regex.Pattern;
import racingcar.constant.GameMessage;

import static racingcar.constant.GameConfig.*;

public class InputValidation {
    private static final String VALIDATE_INPUT_ERROR_MESSAGE =
            GameMessage.VALIDATE_INPUT_ERROR_MESSAGE.getValue();

    private static final String VALIDATE_NAME_LENGTH_ERROR_MESSAGE =
            GameMessage.VALIDATE_NAME_LENGTH_ERROR_MESSAGE.getValue();

    public static void validNameFormat(String name) throws IllegalArgumentException {
        String pattern = "^(?:[^,]+,)*[^,]+$";
        if (!Pattern.matches(pattern, name)) {
            throw new IllegalArgumentException(VALIDATE_INPUT_ERROR_MESSAGE);
        }
    }

    public static void validNameLength(String name) throws IllegalArgumentException {
        if (name.length() > MAX_CAR_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(VALIDATE_NAME_LENGTH_ERROR_MESSAGE);
        }
    }
}