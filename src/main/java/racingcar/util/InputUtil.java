package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputUtil {
    private InputUtil() {}

    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";

    public static final String stringInput() {
        return Console.readLine();
    }

    public static final int covertInteger(String value) {
        if (validNumber(value)) {
            return Integer.parseInt(value);
        }
        throw new IllegalArgumentException("잘못된 입력 값 입니다.");
    }

    private static boolean validNumber(String value) {
        if (Pattern.matches(REGEXP_PATTERN_NUMBER, value)) {
            return true;
        }
        throw new IllegalArgumentException("잘못된 입력 값 입니다.");
    }
}
