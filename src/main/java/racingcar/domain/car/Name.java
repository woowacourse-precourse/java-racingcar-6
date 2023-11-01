package racingcar.domain.car;

public record Name(
        String name
) {
    private static final int MAX_NAME_LENGTH = 5;

    public Name {
        validateName(name);
    }

    private void validateName(final String name) {
        validateNameNullity(name);
        validateNameBlank(name);
        validateNameLength(name);
    }

    private void validateNameNullity(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차 이름은 null이 될 수 없습니다.");
        }
    }

    private void validateNameBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백만으로는 구성할 수 없습니다.");
        }
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
