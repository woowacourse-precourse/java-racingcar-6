package racingcar.validator;

import racingcar.utils.ErrorMessage;

public class InputRacingCarNameValidator {
    public void validate(String input) {
        validateRacingCarNameIsBlank(input);
        validateRacingCarNameLength(input);
    }

    public void validateRacingCarNameIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DOES_NOT_BLANK.getMessage());
        }
    }

    public void validateRacingCarNameLength(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.RACING_CAR_NAME_TOO_LONG.getMessage());
        }
    }
}
