package racingcar.validator;

public class NameLengthValidator implements Validator {
    private static final int MAX_LENGTH = 5;
    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "각 자동차의 이름은 " + MAX_LENGTH + "자 이하여야 합니다.";

    @Override
    public void validate(String name) {
        if (name.length() > MAX_LENGTH) {
            throwException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }
}
