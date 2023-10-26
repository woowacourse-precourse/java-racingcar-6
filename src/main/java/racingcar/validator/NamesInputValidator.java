package racingcar.validator;

public class NamesInputValidator implements Validator {

    @Override
    public void validate(String input) {
        throwIfIsEmpty(input);
    }

    private void throwIfIsEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
