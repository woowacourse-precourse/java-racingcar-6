package racingcar.domain.validator;

public class NameValidator {
    private static int MAXIMUM_NAME = 5;

    public static void validate(String name) {
        maximumName(name);
    }

    private static void maximumName(String name) {
        if (name.length() > MAXIMUM_NAME) {
            throw new IllegalArgumentException("String index out of range: 5");
        }
    }
}
