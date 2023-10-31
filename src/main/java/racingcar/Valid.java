package racingcar;

import java.util.*;

public class Valid {

    private static final String ERROR_MSG = "[ERROR] ";

    public static void isNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MSG + "입력 값이 공백입니다.");
        }
    }

}
