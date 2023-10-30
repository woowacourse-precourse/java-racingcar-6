package validate;

import java.util.List;

public class InputValidation {

    public static void validateNumericInput(String input) {
        if (!input.matches("^[0-9]+$")){
            throw new IllegalArgumentException("입력된 값에 숫자가 아닌 값이 포함되어있습니다.");
        }
    }

    public static void validateInputLengthExceeded(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public static void validateInputIsEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름은 공백일 수 없습니다.");
        }
    }

    public static void validateInputDoesNotContainSpecialCharacters(String name) {
        if (name.matches(".*[ !@#$%^&*(),.?\":{}|<>].*")) {
            throw new IllegalArgumentException("자동차의 이름에는 특수문자 혹은 공백이 들어갈 수 없습니다.");
        }
    }

    public static void validateListIsEmpty(String[] list) {
        if (list.length == 0) {
            throw new IllegalArgumentException("입력된 자동차가 없습니다.");
        }
    }
}
