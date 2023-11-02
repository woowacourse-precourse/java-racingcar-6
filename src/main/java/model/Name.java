package model;

public class Name {

    private final String name;
    private static final int MAX_LENGTH = 5;
    private static final String OVER_LENGTH_MESSAGE = "5글자 미만 이름만 입력 가능합니다.";
    private static final String BELOW_LENGTH_MESSAGE = "공백 혹은 빈 문자열은 입력 할 수 없습니다.";

    public Name(String name) {
        this.name = name;
        validateBelowLength();
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

    private void validateBelowLength() {
        if (isNameEmpty()) {
            throw new IllegalArgumentException(BELOW_LENGTH_MESSAGE);
        }
    }

    private boolean isNameTooLong() {
        return name.trim().length() > MAX_LENGTH;
    }

    private boolean isNameEmpty() {
        return name.isEmpty() || name.isBlank();
    }
}
