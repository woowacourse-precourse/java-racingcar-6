package model;

public class Name {
    private final String name;
    private static final int MAX_LENGTH = 5;
    private static final String TOO_LONG_NAME = "이름은 %d글자 미만이어야 합니다.";

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private static void validateNameLength(String name) {
        if (isNameTooLong(name)) {
            throw new IllegalArgumentException(String.format(TOO_LONG_NAME, MAX_LENGTH));
        }
    }

    private static boolean isNameTooLong(String name) {
        return name.trim().length() >= MAX_LENGTH;
    }
}
