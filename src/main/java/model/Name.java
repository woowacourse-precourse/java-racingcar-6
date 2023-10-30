package model;

public class Name {

    private final String name;
    private static final int MAX_LENGTH = 4;
    private static final String OVER_LENGTH_MESSAGE = "5글자 미만 이름만 입력 가능합니다.";

    public Name(String name) {
        this.name = name;
        validateOverLength();
    }

    public String getName() {
        return name;
    }

    private void validateOverLength() {
        if (isNameTooLong()) {
            throw new IllegalArgumentException(OVER_LENGTH_MESSAGE);
        }
    }

    private boolean isNameTooLong() {
        return name.length() > MAX_LENGTH;
    }
}
