package racingcar.domain.position;

public final class PositionHolder {

    private Position position;

    private PositionHolder(final Position position) {
        this.position = position;
    }

    public static PositionHolder init() {
        return new PositionHolder(Position.init());
    }

    public void increaseBy(final int value) {
        position = position.increased(value);
    }

    public int getPosition() {
        return position.value();
    }
}
