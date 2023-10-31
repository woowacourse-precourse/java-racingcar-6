package racingcar.domain;

import java.util.regex.Pattern;

import static racingcar.utils.Constants.*;

public class NumberValidation {

    public final String ATTEMPT_NUMBER;

    public NumberValidation(String attemptNumber) {
        this.ATTEMPT_NUMBER = attemptNumber;
        isCorrectPattern();
    }

    public void isCorrectPattern() {
        Pattern correctPattern = Pattern.compile(NUMBER_VALIDATION_REGEX.getValue());
        if (!correctPattern.matcher(ATTEMPT_NUMBER).matches()) {
            throw new IllegalArgumentException(INVALID_REPETITION_EXCEPTION.getValue());
        }
    }
}
