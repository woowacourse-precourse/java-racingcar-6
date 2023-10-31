package racingcar.validator;

public class AttemptInputValidator implements Validator {

    private static final String ERROR_INVALID_INPUT = "정수만 입력해주세요. 혹은 integer 범위 내의 정수만 입력해주세요.";
    private static final String ERROR_NEGATIVE_INTEGER = "양의 정수만 입력해주세요.";

    private static final int MIN_NUMBER = 0;

    @Override
    public void validate(String input) {
        throwIfNonInteger(input);
    }

    private void throwIfNonInteger(String input) {
        try {
            int integerInput = Integer.parseInt(input);
            throwIfNonPositive(integerInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }
    }

    private void throwIfNonPositive(int input) {
        if (input <= MIN_NUMBER) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_INTEGER);
        }
    }
}
