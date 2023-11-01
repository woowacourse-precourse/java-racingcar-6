package racingcar.model;

public class Position {

    private static final int DEFAULT_POSITION = 0;

    private int position;

    private Position(final int position) {
        this.position = position;
    }

    public static Position createDefault() {
        return new Position(DEFAULT_POSITION);
    }

    public void increase() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
