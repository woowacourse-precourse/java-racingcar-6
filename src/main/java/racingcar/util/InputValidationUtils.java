package racingcar.util;

public class InputValidationUtils {

    public static void validateHasInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 값 혹은 공백만 입력되었습니다.");
        }
    }

    public static void validateCannotBeInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값을 숫자로 변환할 수 없습니다.");
        }
    }
}
