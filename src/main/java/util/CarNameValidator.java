package util;

public class CarNameValidator {
    private static final int CAR_NAME_LENGTH = 5;
    public static boolean isValidCarName(String name) {
        checkSpaceInName(name);
        return true;
    }

    private static void checkSpaceInName(String name) {
        if (name.contains(" ")) {
            new IllegalArgumentException();
        }
    }
}
