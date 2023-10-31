package racingcar.util;

public class ErrorThrower {
    public static void throwIAE(String message) {
        throw new IllegalArgumentException(message);
    }
}
