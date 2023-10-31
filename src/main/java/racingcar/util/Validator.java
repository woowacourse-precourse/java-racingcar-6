package racingcar.util;

public class Validator {

    public static void validateBlack(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
        }
    }

    public static void validateLength(String input, int length) {
        if (input.length() > length) {
            throw new IllegalArgumentException(length + "자 이하의 값을 입력해주세요.");
        }
    }

    public static int validateInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public static void validateLargeThanParam2(int input, int param2) {
        if (input < param2) {
            throw new IllegalArgumentException(param2 + "이상의 숫자를 입력해주세요.");
        }
    }
}
