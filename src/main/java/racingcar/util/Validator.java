package racingcar.util;

public class Validator {
    static void throwIllegalArgumentException(String message) {
        throw new IllegalArgumentException(message);
    }

    static void throwIllegalArgumentException(String message, Throwable t) {
        throw new IllegalArgumentException(message, t);
    }
}