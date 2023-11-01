package racingcar.model;

public class CarValidator {

    private static final int MAX_NAME_SIZE = 5;

    public static boolean validateMaxNameLength(String source) {
        return MAX_NAME_SIZE < source.length();
    }

    public static boolean validateNameIsNull(String source) {
        return source.trim().isEmpty();
    }
}
