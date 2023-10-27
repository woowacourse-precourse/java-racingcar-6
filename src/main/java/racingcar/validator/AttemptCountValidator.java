package racingcar.validator;

import racingcar.Constants;

public enum AttemptCountValidator {
    INSTANCE;

    public void validate(String input) {
        checkAttemptCountIsInteger(input);
    }

    private void checkAttemptCountIsInteger(String input) {
        if (!Constants.INTEGER.matcher(input).matches()) {
            throw new IllegalArgumentException("정수를 입력해야합니다.");
        }
    }
}
