package racingcar.exception;

public class RaceException {

    public static void validateCarName(String name) {
        if (name == null || name.length() > 5 || name.length() < 1) {
            throw new IllegalArgumentException();
        }
    }
}
