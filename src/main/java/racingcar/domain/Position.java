package racingcar.domain;

public record Position(int value) {
    private static final int MIN_POSITION = 0;
    private static final String INVALID_POSITION = "위치는 음수일 수 없습니다.";

    public Position {
        validate(value);
    }

    public Position increment() {
        return new Position(this.value + 1);
    }

    private void validate(int value) {
        if (value < MIN_POSITION) {
            throw new IllegalArgumentException(INVALID_POSITION);
        }
    }

    public int compareTo(Position position) {
        return Integer.compare(this.value, position.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
