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

    public int validateIsNumberAndReturnAsInt(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch {
            throw new IllegalArgumentException("0이상 2147483647 이하의 숫자를 입력해야 합니다.");
        }

    }


}
