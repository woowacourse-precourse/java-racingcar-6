package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static void validateCarNames(String[] separatedCarNames) {
        if (isCarNamesOutOfSize(separatedCarNames)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isCarNamesOutOfSize(String[] separatedCarNames) {
        List<Boolean> sizeChecker = new ArrayList<>();
        for (int i = 0; i < separatedCarNames.length; i++) {
            if (separatedCarNames[i].length() > 5) {
                sizeChecker.add(true);
            }
        }
        return sizeChecker.contains(true);
    }


    public static void validateAttemptsNumber(String attempts) {
        try {
            Integer.parseInt(attempts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateAttemptsRange(String attempts) {
        if (isAttemptsOutOfRange(attempts)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isAttemptsOutOfRange(String attempts) {
        return Integer.parseInt(attempts) < 1;
    }
}
