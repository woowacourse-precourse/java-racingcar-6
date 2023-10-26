package racingcar.util;

public class Validation {

    public static void valiEmptySplitInputCarNames(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException("Empty split to carNames Array");
        }
    }
}
