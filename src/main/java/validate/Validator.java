package validate;

public class Validator {

    private static final int MAX_LENGTH = 5;
    private static final String TOO_LONG_NAME = "이름은 %d글자 미만이어야 합니다.";

    private Validator() {
    }

    public static void validateNameLength(String name) {
        if (isNameTooLong(name)) {
            throw new IllegalArgumentException(String.format(TOO_LONG_NAME, MAX_LENGTH));
        }
    }

    private static boolean isNameTooLong(String name) {
        return name.length() >= MAX_LENGTH;
    }
}
