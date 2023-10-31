package racingcar;

import java.util.*;

public class Valid {

    private static final String ERROR_MSG = "[ERROR] ";

    public static void isNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MSG + "입력 값이 공백입니다.");
        }
    }

    public static void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MSG + "시도 횟수는 숫자여야 합니다.");
        }
    }
}
