package Validator;

public class StringValidator {

    private static StringValidator stringValidator;

    private StringValidator() {

    }

    public static StringValidator getInstance() {
        if (StringValidator.stringValidator == null) {
            return StringValidator.stringValidator = new StringValidator();
        }
        return StringValidator.stringValidator;
    }

    public void validatetNotBlankString(String input) {
        if (input.length() == 0 || input == null) {
            throw new IllegalArgumentException("자동차의 이름은 공백일 수 없습니다.");
        }
    }


}
