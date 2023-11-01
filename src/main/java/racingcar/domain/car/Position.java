package racingcar.domain.car;

public record Position(int currentPosition) {

    private static final String POSITION_PATTERN = "-";

    public String expressPosition() {
        return POSITION_PATTERN.repeat(currentPosition);
    }

    @Override
    public String toString() {
        return expressPosition();
    }
}
