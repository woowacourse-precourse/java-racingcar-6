package racingcar;

public class Position {

    private static final int DEFAULT_POSITION_VALUE = 0;
    private int position;

    public Position() {
        this.position = DEFAULT_POSITION_VALUE;
    }

    public int getValue() {
        return position;
    }

    public void move(Movement movement) {
        this.position += movement.addingValue();
    }
}