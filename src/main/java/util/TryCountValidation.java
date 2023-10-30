package util;

public class TryCountValidation {
    public static void checkTryCountValidation(int tryCount) {

    }

    private static boolean validatedRange(int tryCount) {
        if (tryCount > 9 || tryCount < 0) {
            return false;
        }
        return true;
    }

}
