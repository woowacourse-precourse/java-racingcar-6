package util;

public class CarNameValidator {
    private static final int CAR_NAME_LENGTH = 5;

    public static boolean isValidCarName(String name) {
        checkSpaceInName(name);
        checkNameLength(name);
        return true;
    }

    private static void checkSpaceInName(String name) {
        if (name.contains(" ")) {
            new IllegalArgumentException();
        }
    }

    private static void checkNameLength(String name) {
        if (name.length() > CAR_NAME_LENGTH) {
            new IllegalArgumentException();
        }
    }
}
