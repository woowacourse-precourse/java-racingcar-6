package validate;

public class InputValidation {

    public static void validateNumericInput(String input) {
        if (!input.matches("^[0-9]+$")){
            throw new IllegalArgumentException("입력된 값에 문자열이 포함되어있습니다.");
        }
    }

    public static void validateInputLengthExceeded(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public static void validateInputIsEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름은 공백일 수 없습니다.");
        }
    }

    public static void validateInputDoseNotContainSpecialCharacters(String input) {
        if (input.matches(".*[ !@#$%^&*(),.?\":{}|<>].*")) {
            throw new IllegalArgumentException("자동차의 이름에는 특수문자 혹은 공백이 들어갈 수 없습니다.");
        }
    }
}
