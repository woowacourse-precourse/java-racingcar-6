package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validator {
    private static final String INVALID_INPUT = "유효하지 않은 입력입니다.";
    private static final String BLANK = " ";
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final int ZERO = 0;

    private Validator() {
        throw new IllegalArgumentException();
    }

    public static void validateCarName(String carName) {
        validateLength(carName);
        validateBlank(carName);
    }

    public static void validateLength(String carName) {
        if (!isValidLength(carName)) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    public static boolean isValidLength(String carName) {
        return carName.length() >= MIN_LENGTH && carName.length() <= MAX_LENGTH;
    }

    public static void validateBlank(String carName) {
        if (carName.contains(BLANK)) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    public static void validateDuplicate(String[] carNames) {
        Set<String> uniqueCarNames = new HashSet<>(Arrays.asList(carNames));

        if (uniqueCarNames.size() != carNames.length) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    public static int validateRound(String input) {
        int round = validateRoundType(input);
        isValidRoundRange(round);
        return round;
    }

    public static int validateRoundType(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    public static void isValidRoundRange(int round) {
        if (round <= ZERO) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }
}
