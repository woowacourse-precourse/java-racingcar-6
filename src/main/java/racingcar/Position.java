package racingcar;

public class Position {

    private int position;

    public Position() {
        this.position = 0;
    }

    public int getValue() {
        return position;
    }

    public void move(Movement movement) {
        this.position += movement.addingValue();
    }
}