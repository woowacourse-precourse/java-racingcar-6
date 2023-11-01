package racingcar.validator;

import java.util.regex.Pattern;

public class InputValidator {
    public static void isNullOrIsEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("아무 것도 입력하지 않았습니다.");
        }
    }

    public static void includeNumberOrSymbolExceptComma(String input) {
        if (!Pattern.matches("^[a-z|A-Z|,|\\s]*$", input)) {
            throw new IllegalArgumentException("쉼표 외 특수 기호 혹은 숫자가 포함되어 있습니다.");
        }
    }

    public static void includeSpace(String input) {
        if (input.contains(", ")) {
            throw new IllegalArgumentException("구분자 뒤 공백이 없어야 합니다.");
        }
    }

    public static void isNotDigit(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다. 숫자를 입력하세요.");
        }
    }
}
