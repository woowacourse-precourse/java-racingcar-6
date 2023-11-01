package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    private static final String NON_INTEGER_MESSAGE = "시도 횟수는 정수여야 합니다.";

    public static List<String> parseCarNames(String input) {
        return Arrays.asList(input.split(","));
    }

    public static int parseAttemptCount(String attemptCount) {
        try {
            return Integer.parseInt(attemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_MESSAGE, e);
        }
    }

}
