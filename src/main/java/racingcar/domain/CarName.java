package racingcar.domain;

public class CarName {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        int nameLength = name.length();
        boolean isLengthBelow = nameLength < MIN_LENGTH;
        boolean isLengthOver = nameLength > MAX_LENGTH;
        if (isLengthBelow || isLengthOver) {
            throw new IllegalArgumentException();
        }
    }

}
