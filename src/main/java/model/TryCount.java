package model;

public class TryCount {

    private static final int MIN_TRY_COUNT = 1;

    private final int tryCount;

    private TryCount(final int tryCount) {
        this.tryCount = tryCount;
    }

    public static TryCount from(final String value) {
        validateDigitValue(value);

        int intValue = Integer.parseInt(value);
        validateRange(intValue);

        return new TryCount(intValue);
    }

    private static void validateRange(final int intValue) {
        if (isInValidRange(intValue)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDigitValue(final String value) {
        if (!isDigit(value)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isInValidRange(final int intValue) {
        return intValue < MIN_TRY_COUNT;
    }

    private static boolean isDigit(final String value) {
        return value.chars()
            .allMatch(Character::isDigit);
    }

    public int getTryCount() {
        return tryCount;
    }
}
