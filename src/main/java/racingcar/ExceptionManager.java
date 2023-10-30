package racingcar;

import java.util.List;

public class ExceptionManager {
    public static boolean isNegative(int attemptNum) {
        if (attemptNum < 1) {
            return true;
        }
        return false;
    }

    public static boolean isNum(String input) {
        if (input.matches("\\d+")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isBlank(String input) {
        if (input.isBlank()) {
            return true;
        }
        return false;
    }
}
