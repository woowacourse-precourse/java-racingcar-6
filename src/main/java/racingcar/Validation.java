package racingcar;

public class Validation {

    public static void validateCarNames(String[] names) {
        if (names.length == 0) {
            throw new IllegalArgumentException();
        }

        for (String name : names) {
            if (name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
