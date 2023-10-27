package racingcar.domain;

public final class CarName {
    private final String name;

    public CarName(String name) {
        this.name = name;
        validate();
    }

    private void validate() {
        validateLength();
    }

    private void validateLength() {
        if (name.length() > 5) {
            throw new IllegalArgumentException("Error: 자동차의 이름은 5자 이하여야 합니다.");
        }
    }
}
