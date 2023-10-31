package racingcar.validator;

import java.util.regex.Pattern;
import racingcar.constants.ExceptionMessage;

public enum AttemptCountValidator {
    INSTANCE;
    private static final Pattern INTEGER = Pattern.compile("[0-9]+");

    public void validate(String input) {
        checkAttemptCountIsInteger(input);
    }

    private void checkAttemptCountIsInteger(String input) {
        if (isNotInteger(input)) {
            throw new IllegalArgumentException(ExceptionMessage.NON_INTEGER.message());
        }
    }

    private boolean isNotInteger(String input) {
        return !INTEGER.matcher(input).matches();
    }
}
