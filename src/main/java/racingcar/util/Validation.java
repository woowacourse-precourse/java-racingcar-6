package racingcar.util;

public class Validation {
    private static final int CAR_NAME_LENGTH = 5;

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
}
