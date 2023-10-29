package racingcar.validator;

import java.util.regex.Pattern;

import static racingcar.constant.GameConfig.*;
import static racingcar.constant.GameMessage.*;
public class InputValidation {
    public static void validNameFormat(String name) throws IllegalArgumentException{
        String pattern = "^(?:[^,]+,)*[^,]+$";
        if (!Pattern.matches(pattern, name))
            throw new IllegalArgumentException(
                    VALIDATE_INPUT_ERROR_MESSAGE.getValue()
            );
    }
    public static void validNameLength(String name) throws IllegalArgumentException{
        if (name.length() > MAX_CAR_NAME_LENGTH.getValue())
            throw new IllegalArgumentException(
                    VALIDATE_NAME_LENGTH_ERROR_MESSAGE.getValue()
            );
    }
}
