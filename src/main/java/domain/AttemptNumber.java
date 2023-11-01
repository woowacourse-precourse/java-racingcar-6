package domain;

import ui.Output;

import java.util.Objects;

public class AttemptNumber {
    public static final int MIN_ATTEMPT_NUMBER = 0;

    private final int attemptNumber;

    public AttemptNumber(String userInput) {
        isNull(userInput);

        this.attemptNumber = isNumberFormat(userInput);
        isValidNumber();
    }

    private void isNull(String userInput) {
        if (Objects.isNull(userInput)) {
            throw new IllegalArgumentException(Output.NULL_EXCEPTION_MESSAGE);
        }
    }

    private int isNumberFormat(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Output.ATTEMPT_NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private void isValidNumber() {
        if (attemptNumber <= MIN_ATTEMPT_NUMBER) {
            throw new IllegalArgumentException(Output.VALID_ATTEMPT_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }
}
