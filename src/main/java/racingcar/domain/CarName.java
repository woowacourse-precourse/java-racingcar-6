package racingcar.domain;

public final class CarName {
    private static final int MAX_LENGTH = 5;
    private static final String LENGTH_EXCEPTION_MESSAGE =
            String.format("Error: 자동차의 이름은 %d자 이하여야 합니다.", MAX_LENGTH);
    private static final String BLANK_EXCEPTION_MESSAGE = "Error: 자동차의 이름은 공백이거나 비어있을 수 없습니다.";

    private final String name;

    public CarName(String name) {
        this.name = name;
        validate();
    }

    private void validate() {
        validateLength();
        validateIsBlank();
    }

    private void validateLength() {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private void validateIsBlank() {
        if (name.isBlank()) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CarName carName)) {
            return false;
        }

        return name.equals(carName.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String getName() {
        return name;
    }
}
