package racingcar.validator;

import static racingcar.config.ErrorMessage.INPUT_CAR_NAME_COMMA_ERROR_MESSAGE;
import static racingcar.config.ErrorMessage.INPUT_CAR_NAME_LENGTH_ERROR_MESSAGE;
import static racingcar.config.InputPattern.INPUT_CAR_NAME_COMMA_REGEX;
import static racingcar.config.InputPattern.INPUT_CAR_NAME_LENGTH_REGEX;

import java.util.regex.Pattern;

public class InputCarNameValidator implements Validator<String> {
    private static final Pattern INPUT_CAR_NAME_LENGTH_PATTERN =
            Pattern.compile(INPUT_CAR_NAME_LENGTH_REGEX.getRegex());
    private static final Pattern INPUT_CAR_NAME_COMMA_PATTERN =
            Pattern.compile(INPUT_CAR_NAME_COMMA_REGEX.getRegex());

    public String validate(String inputCarName) {
        String lengthErrorMessage = INPUT_CAR_NAME_LENGTH_ERROR_MESSAGE.getMessage();

        if (!INPUT_CAR_NAME_LENGTH_PATTERN.matcher(inputCarName).matches()) {
            throw new IllegalArgumentException(lengthErrorMessage);
        }
        if (!INPUT_CAR_NAME_COMMA_PATTERN.matcher(inputCarName).matches()) {
            throw new IllegalArgumentException(INPUT_CAR_NAME_COMMA_ERROR_MESSAGE.getMessage());
        }
        return inputCarName;
    }
}
