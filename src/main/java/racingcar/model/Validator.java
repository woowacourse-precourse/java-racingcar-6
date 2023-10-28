package racingcar.model;

public class Validator {

    public static boolean validateMaxNameLength(String source) {
        return 5 < source.length();
    }

    public static boolean validateNameIsNull(String source) {
        return source.trim().isEmpty();
    }
}
