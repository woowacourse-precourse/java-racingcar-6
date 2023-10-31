package racingcar.model;

public class Position {
    private static final Integer START_POSITION = 0;
    private int position;

    public Position() {
        this.position = START_POSITION;
    }

    public void move(int number) {
        this.position += number;
    }

    public int getPosition() {
        return this.position;
    }
}