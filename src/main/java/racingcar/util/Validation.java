package racingcar.util;

public class Validation {
    private static final int CAR_NAME_LENGTH = 5;

    public static void valiEmptySplitInputCarNames(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException("Empty split to carNames Array");
        }
    }

    private static void valiCarNameLength(String carName) {
        if (carName.length() <= CAR_NAME_LENGTH && carName.length() > 0) {
            return;
        }
        throw new IllegalArgumentException("Invalid car name length");
    }
}
