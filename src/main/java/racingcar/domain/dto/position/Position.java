package racingcar.domain.dto.position;

public record Position(int value) {
    private static final int MIN_POSITION = 0;

    public Position {
        validateMinPosition(value);
    }

    public static Position init() {
        return new Position(MIN_POSITION);
    }

    private static void validateMinPosition(final int value) {
        if (value < MIN_POSITION) {
            throw new IllegalArgumentException("최소 포지션은 0");
        }
    }

    public Position increased(final int value) {
        return new Position(this.value + value);
    }
}
