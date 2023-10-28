package racingcar;

public class Position {

    private static final int DEFAULT_POSITION = 0;
    private int position;

    public Position(Position position) {
        this.position = position.position;
    }

    public Position(int position) {
        this.position = position;
    }

    public Position() {
        this.position = DEFAULT_POSITION;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
