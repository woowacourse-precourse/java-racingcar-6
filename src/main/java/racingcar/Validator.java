package racingcar;

public class Validator {
    public static final int CAR_NAME_LENGTH_LIMIT = 5;

    public static void validateCarNames(String[] delimitedCarNames) {
        if (isCarNamesOutOfLength(delimitedCarNames)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isCarNamesOutOfLength(String[] delimitedCarNames) {
        for (int i = 0; i < delimitedCarNames.length; i++) {
            if (delimitedCarNames[i].length() > CAR_NAME_LENGTH_LIMIT) {
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
        return Integer.parseInt(round) < 1;
    }
}
