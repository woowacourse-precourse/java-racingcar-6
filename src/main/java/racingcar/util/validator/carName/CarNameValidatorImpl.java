package racingcar.util.validator.carName;

public class CarNameValidatorImpl implements CarNameValidator {
    private final int MAX_LENGTH = 5;

    @Override
    public boolean validateName(String input) {
        return isShorterThanOrEqualToMaxLength(input);
    }

    private boolean isShorterThanOrEqualToMaxLength(String input) {
        return input.length() <= MAX_LENGTH;
    }
}
