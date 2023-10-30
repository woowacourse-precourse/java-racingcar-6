package racingcar.util;

public final class NullValidator {

    private NullValidator() {
    }

    public static void checkNotNull(Object obj, String exceptionMessage) {
        if (obj == null) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
