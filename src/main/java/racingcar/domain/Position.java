package racingcar.domain;

public record Position(int position) {
    private static final int CAR_MOVE_POSITION = 1;
    public Position move() {
        return new Position(position + CAR_MOVE_POSITION);
    }
}
