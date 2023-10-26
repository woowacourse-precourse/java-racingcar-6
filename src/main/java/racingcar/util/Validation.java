package racingcar.util;

public class Validation {
    private static final int CAR_NAME_LENGTH = 5;

    public static void valiRacingCount(String racingCount) {
        if (isNumber(racingCount) && isNaturalNumber(Integer.parseInt(racingCount))) {
            return;
        }
        throw new IllegalArgumentException("Invalid racingCount");
    }

    public static void valiEmptySplitInputCarNames(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException("Empty split to carNames Array");
        }
    }

    public static void valiCarName(String carName) {
        valiEmptyCarName(carName);
        valiCarNameLength(carName);
    }

    private static void valiCarNameLength(String carName) {
        if (carName.length() <= CAR_NAME_LENGTH && carName.length() > 0) {
            return;
        }
        throw new IllegalArgumentException("Invalid car name length");
    }

    private static void valiEmptyCarName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("Invalid car name isEmpty");
        }
    }

    private static boolean isNumber(String racingCount) {
        try {
            Integer.parseInt(racingCount);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isNaturalNumber(int racingCount) {
        return racingCount > 0;
    }
}
