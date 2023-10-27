package racingcar.util.validator;

public class CarNameValidatorImpl implements CarNameValidator {
    private final int MAX_LENGTH = 5;

    @Override
    public boolean validate(String input) {
        return isShorterThanOrEqualsToMaxLength(input);
    }

    private boolean isShorterThanOrEqualsToMaxLength(String input) {
        return input.length() <= MAX_LENGTH;
    }
}
