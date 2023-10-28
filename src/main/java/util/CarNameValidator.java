package util;

public class CarNameValidator {
    private static final int CAR_NAME_LENGTH = 5;
    private static final String SPACE = " ";

    public static void checkValidCarName(String name) {
        checkSpaceInName(name);
        checkNameLength(name);
    }

    private static void checkSpaceInName(String name) {
        if (name.contains(SPACE)) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkNameLength(String name) {
        if (name.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
