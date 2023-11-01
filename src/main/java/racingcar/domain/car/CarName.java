package racingcar.domain.car;

public record CarName(String name) {
    private static final int MAX_LENGTH = 5;
    private static final String LENGTH_EXCEPTION_MESSAGE =
            String.format("Error: 자동차의 이름은 %d자 이하여야 합니다.", MAX_LENGTH);
    private static final String BLANK_EXCEPTION_MESSAGE = "Error: 자동차의 이름은 공백이거나 비어있을 수 없습니다.";

    public CarName {
        validate(name);
    }

    private void validate(String name) {
        validateLength(name);
        validateIsBlank(name);
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private void validateIsBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MESSAGE);
        }
    }
}
