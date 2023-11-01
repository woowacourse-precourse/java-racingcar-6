package racingcar.domain.car;

public record Name(
        String name
) {
    private static final int MAX_NAME_LENGTH = 5;

    public Name {
        validate(name);
    }

    private void validate(final String name) {
        validateNullity(name);
        validateBlank(name);
        validateLength(name);
    }

    private void validateNullity(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차 이름은 null이 될 수 없습니다.");
        }
    }

    private void validateBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백만으로는 구성할 수 없습니다.");
        }
    }

    private void validateLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
