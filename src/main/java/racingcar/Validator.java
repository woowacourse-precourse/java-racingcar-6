package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static final int CAR_NAME_RANGE_LIMIT = 5;

    public static void validateCarNames(String[] delimitedCarNames) {
        if (isCarNamesOutOfSize(delimitedCarNames)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isCarNamesOutOfSize(String[] delimitedCarNames) {
        List<Boolean> sizeChecker = new ArrayList<>();
        for (int i = 0; i < delimitedCarNames.length; i++) {
            if (delimitedCarNames[i].length() > CAR_NAME_RANGE_LIMIT) {
                sizeChecker.add(true);
            }
        }
        return sizeChecker.contains(true);
    }


    public static void validateRoundNumber(String round) {
        try {
            Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRoundRange(String round) {
        if (isRoundOutOfRange(round)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isRoundOutOfRange(String round) {
        return Integer.parseInt(round) < 1;
    }
}
