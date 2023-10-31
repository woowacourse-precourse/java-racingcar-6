package racingcar.Util;

public class ErrorCollection {

    public static void IllegalEmptyInput() {
        throw  new IllegalArgumentException(ErrorMessage.EMPTY.label());
    }

    public static void IllegalCarNames() {
        throw new IllegalArgumentException(ErrorMessage.NAME.label());
    }

    public static void IllegalAttempts() {
        throw new IllegalArgumentException(ErrorMessage.ATTEMPT.label());
    }
}
