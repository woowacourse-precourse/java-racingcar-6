package validation;

import static constant.Constant.BLANK;
import static constant.Constant.NAME_LENGTH_LIMIT;
import static constant.ErrorMessage.EMPTY_NAME_CASE_MESSAGE;
import static constant.ErrorMessage.EXCEED_NAME_CASE_MESSAGE;
import static constant.ErrorMessage.NOT_POSITIVE_NUMBER_INPUT_CASE_MESSAGE;
import static constant.ErrorMessage.UNCOMPETITIVE_CASE_MESSAGE;

public class UserInputValidator {
    public void validatePositiveNumber(Integer number) {
        if (isNullOrLessThanOne(number)) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_INPUT_CASE_MESSAGE);
        }
    }

    private static boolean isNullOrLessThanOne(Integer number) {
        return number == null || number < 1;
    }

    public void validateInputCarName(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(EMPTY_NAME_CASE_MESSAGE);
        } else if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(EXCEED_NAME_CASE_MESSAGE);
        }
    }

    public void validateInputCarNameCount(String[] names) {
        if (names.length < 2) {
            throw new IllegalArgumentException(UNCOMPETITIVE_CASE_MESSAGE);
        }
    }
}