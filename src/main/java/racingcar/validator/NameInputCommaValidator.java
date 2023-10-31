package racingcar.validator;

public class NameInputCommaValidator implements Validator<String> {
    private static final String NAMES_INPUT_EXCEPTION_MESSAGE = "2개 이상의 자동차 이름을 쉼표(,) 기준으로 구분하여 작성해 주십시오.";

    @Override
    public void validate(String playerInput) {
        if (!playerInput.contains(",")) {
            throwException(NAMES_INPUT_EXCEPTION_MESSAGE);
        }
    }
}