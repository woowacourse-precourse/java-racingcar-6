package racingcar.utils.types;


import racingcar.utils.exception.StringUtilsExceptionType;

public class StringUtils {

    private StringUtils() {
        throw new UnsupportedOperationException();
    }

    public static boolean isLengthInRange(final String value, final int startLength, final int endLength) {
        if (value == null || startLength < 0 || endLength < 0) {
            throw new IllegalArgumentException(StringUtilsExceptionType.OUT_OF_RANGE.getMessage());
        }

        final int valueLength = value.length();

        return startLength <= valueLength && valueLength <= endLength;
    }

    public static boolean isNumeric(final String value) {
        if (value == null) {
            throw new IllegalArgumentException(StringUtilsExceptionType.NOT_NUMERIC.getMessage());
        }
        if (StringUtils.isLengthEqual(value, 0)) {
            return false;
        }

        return value.chars().allMatch(Character::isDigit);
    }

    public static boolean isLengthEqual(final String value, final int length) {
        if (value == null || length < 0) {
            throw new IllegalArgumentException(StringUtilsExceptionType.NOT_SAME_LENGTH.getMessage());
        }
        return value.length() == length;
    }
}
