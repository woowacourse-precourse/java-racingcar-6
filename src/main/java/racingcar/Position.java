package racingcar;

public class Position {

    private int position;

    public Position() {
        this.position = 0;
    }

    public void move(Movement movement) {
        this.position += movement.addingValue();
    }
}