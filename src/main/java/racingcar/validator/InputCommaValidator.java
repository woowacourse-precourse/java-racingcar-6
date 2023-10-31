package racingcar.validator;

public class InputCommaValidator extends Validator {
    private static final String INPUT_FIRST_COMMA_MESSAGE = "자동차 이름 입력이 (,) 쉼표로 시작되면 안됩니다.";
    private static final String INPUT_MIDDLE_COMMA_DUPLICATE_MESSAGE = "자동차 이름에는 (,) 연속된 쉼표를 입력해서는 안됩니다.";
    private static final String INPUT_DUPLICATE_VALIDATE_MESSAGE = "자동차 이름 입력 끝에는 (,) 쉼표가 있으면 안됩니다.";

    @Override
    public void validate(String carName) throws IllegalArgumentException {
        validateFirstComma(carName);

        validateMiddleCommaRepeat(carName);

        validateLastComma(carName);
    }

    private void validateFirstComma(String names) throws IllegalArgumentException {
        if (names.charAt(0) == ',') {
            throw new IllegalArgumentException(INPUT_FIRST_COMMA_MESSAGE);
        }
    }

    private void validateMiddleCommaRepeat(String names) throws IllegalArgumentException {
        String commaRepeat = ",,";
        if (names.contains(commaRepeat)) {
            throw new IllegalArgumentException(INPUT_MIDDLE_COMMA_DUPLICATE_MESSAGE);
        }
    }

    private void validateLastComma(String names) throws IllegalArgumentException {
        int len = names.length();
        if (names.charAt(len - 1) == ',') {
            throw new IllegalArgumentException(INPUT_DUPLICATE_VALIDATE_MESSAGE);
        }
    }
}
