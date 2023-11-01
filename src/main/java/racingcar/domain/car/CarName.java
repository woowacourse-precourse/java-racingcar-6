package racingcar.domain.car;

public record CarName(String name) {

    private static final String INVALID_LENGTH_EXCEPTION_MESSAGE = "이름의 길이가 올바르지 않습니다.";

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    public CarName {
        validateNameLength(name);
    }

    private void validateNameLength(String name) {
        int nameLength = name.length();
        boolean isLengthBelow = nameLength < MIN_LENGTH;
        boolean isLengthOver = nameLength > MAX_LENGTH;
        if (isLengthBelow || isLengthOver) {
            throw new IllegalArgumentException(INVALID_LENGTH_EXCEPTION_MESSAGE);
        }
    }

}
