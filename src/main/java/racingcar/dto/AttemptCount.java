package racingcar.dto;

import racingcar.validator.AttemptCountValidator;

public class AttemptCount {
    private final int attemptCount;

    public AttemptCount(String input) {
        AttemptCountValidator validator = AttemptCountValidator.INSTANCE;
        validator.validate(input);

        attemptCount = toInt(input);
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
