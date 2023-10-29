package racingcar.validator;

public class CountInputValidator implements Validator<String> {
    private static final String COUNT_INPUT_EXCEPTION_MESSAGE = "숫자만 입력해주십시오.";
    private static final String ONLY_NUMBER_REGEX = "\\d+";

    @Override
    public void validate(String playerInput) {
        if (!playerInput.matches(ONLY_NUMBER_REGEX)) {
            throwException(COUNT_INPUT_EXCEPTION_MESSAGE);
        }
    }
}
