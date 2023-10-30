package racingcar.validator;

import static racingcar.config.ErrorMessage.INPUT_CAR_NAME_COMMA_ERROR_MESSAGE;
import static racingcar.config.ErrorMessage.INPUT_CAR_NAME_LENGTH_ERROR_MESSAGE;
import static racingcar.config.InputPattern.INPUT_CAR_NAME_COMMA_REGEX;
import static racingcar.config.InputPattern.INPUT_CAR_NAME_LENGTH_REGEX;

public class InputCarNameValidator implements Validator<String> {
    public String validate(String inputCarName) {
        String lengthErrorMessage = INPUT_CAR_NAME_LENGTH_ERROR_MESSAGE.getMessage();

        if (!inputCarName.matches(INPUT_CAR_NAME_LENGTH_REGEX.getRegex())) {
            throw new IllegalArgumentException(lengthErrorMessage);
        }
        if (!inputCarName.matches(INPUT_CAR_NAME_COMMA_REGEX.getRegex())) {
            throw new IllegalArgumentException(INPUT_CAR_NAME_COMMA_ERROR_MESSAGE.getMessage());
        }
        return inputCarName;
    }
}
