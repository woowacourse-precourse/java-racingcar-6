package racingcar;

public class Name {

    private static final int VALID_LENGTH = 5;
    private static final String INVALID_LENGTH = "이름은 최소 한글자 이상, 다섯글자 이하여야 합니다.";
    private final String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > VALID_LENGTH || name.isBlank()) {
            throw new IllegalArgumentException(INVALID_LENGTH);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}