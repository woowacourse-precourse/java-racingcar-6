package racingcar.validator;

public class NamesInputValidator implements Validator {

    private static final String ERROR_EMPTY_INPUT = "이름을 입력해주세요!";

    @Override
    public void validate(String input) {
        throwIfIsEmpty(input);
    }

    private void throwIfIsEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_INPUT);
        }
    }
}
