package racingcar;

public class Validator {

    public static void validateIsBlank(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("잘못된 입력값입니다.(빈칸 혹은 공백)");
        }
    }

    public static void validateIsInteger(String value) {
        if (!isInteger(value)) {
            throw new IllegalArgumentException("정수만 입력해 주세요.");
        }
    }

    private static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private Validator() {
    }
}