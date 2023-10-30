package racingcar;

public class ExceptionManager {
    public static void isNegative(int attemptNum) {
        if (attemptNum < 1) {
            throw new IllegalArgumentException("시도 회수는 1 이상만 가능합니다.");
        }
    }

    public static boolean isNum(String input) {
        if (input.matches("\\d+")) {
            return true;
        } else {
            throw new IllegalArgumentException("시도 회수는 숫자만 가능합니다.");
        }
    }

    public static boolean isBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("시도 회수는 공백이 될 수 없습니다.");
        }
        return true;
    }
}
