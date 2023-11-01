package racingcar.exception;

public class Exception {
    public static void invalidValueEntered(String args) {
        throw new IllegalArgumentException(args);
    }
}
