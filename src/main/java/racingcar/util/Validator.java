package racingcar.util;

public class Validator {
    static void throwIllegalArgumentException(String message) {
        throw new IllegalArgumentException(generateErrorMessage(message));
    }

    static void throwIllegalArgumentException(String message, Throwable t) {
        throw new IllegalArgumentException(generateErrorMessage(message), t);
    }

    static private String generateErrorMessage(String message) {
        return "[ERROR] " + message;
    }
}
