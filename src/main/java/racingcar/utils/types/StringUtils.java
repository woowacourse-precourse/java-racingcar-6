package racingcar.utils.types;


public class StringUtils {

    private StringUtils() {
        throw new UnsupportedOperationException();
    }

    public static boolean isLengthInRange(final String value, final int startLength, final int endLength) {
        if (value == null || startLength < 0 || endLength < 0) {
            throw new IllegalArgumentException();
        }

        final int valueLength = value.length();

        return startLength <= valueLength && valueLength <= endLength;
    }
}
