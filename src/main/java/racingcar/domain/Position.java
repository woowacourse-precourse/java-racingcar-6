package racingcar.domain;

public class Position {

    private static final int START_POSITION = 0;

    private int position;

    public Position() {
        this.position = START_POSITION;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        this.position++;
    }

}
