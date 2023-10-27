package racingcar.validator;

public class AttemptInputValidator implements Validator {

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
            throw new IllegalArgumentException();
        }
    }

    private void throwIfNonPositive(int input) {
        if (input <= MIN_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
