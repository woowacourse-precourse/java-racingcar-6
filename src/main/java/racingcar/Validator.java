package racingcar;

public class Validator {
    private static final int CAR_NAME_LENGTH_MAX_LIMIT = 5;
    private static final int ROUND_RANGE_MIN_LIMIT = 1;

    public static void validateCarNames(String[] separatedCarNames) {
        if (isCarNamesOutOfLength(separatedCarNames)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isCarNamesOutOfLength(String[] separatedCarNames) {
        for (String carName : separatedCarNames) {
            if (carName.length() > CAR_NAME_LENGTH_MAX_LIMIT) {
                return true;
            }
        }
        return false;
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
        return Integer.parseInt(round) < ROUND_RANGE_MIN_LIMIT;
    }
}