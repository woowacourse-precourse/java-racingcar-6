package racingcar;

public class Position {

    private static final int DEFAULT_POSITION = 0;
    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public Position() {
        this.position = DEFAULT_POSITION;
    }
}
