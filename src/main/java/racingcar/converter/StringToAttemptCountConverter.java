package racingcar.converter;

import racingcar.validation.InputValidator;

public class StringToAttemptCountConverter {

    private final InputValidator inputValidator = new InputValidator();

    public int execute(String attemptCount) {
        inputValidator.attemptCount(attemptCount);
        return Integer.parseInt(attemptCount);
    }
}
