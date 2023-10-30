package util;

public class TryCountValidation {
    public static void checkTryCountValidation(String tryCount) {
        if (!isNumber(tryCount)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNumber(String tryCount) {
        if (!tryCount.matches("^[0-9]*$")) {
            return false;
        }
        return true;
    }
}
